package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector = new DBConnector();
//				dbConnectorのgetメソッドをコネクション型のconnection変数に代入
	private Connection connection = dbConnector.getConnection();
	private com.internousdev.ecsite.dto.LoginDTO loginDTO = new LoginDTO();
//	メソッド名は処理内容をわかりやすくするためにgetLoginUserInfoにしています。
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword) {
//		sql文をまずは文字列に変換。login_uesr_transactionテーブルからlogin_idとlogin_passをselectで参照し変換。
//		login_id = ? login_pass = ?←２つの条件を満たしたデータがsql文に代入されます。

		String sql = "SELECT * FROM login_user_transaction WHERE login_id = ? AND login_pass = ?";
//		？←プレースホルダーと言ってその都度違うデータを入れていきたいときに使用する。

//		try~catchはJavaの例外処理の為の構文。
//		tryの中でエラーが発生した場合にcatchが受け取りprintStackTraceでエラーに至る"履歴"を表示してくれます
//		try文はエラーが起こりそうなのを入れる(内的(構文の間違い)外的(Wifiが繋がらなかったなど)を含めるためここに記述)
		try {
//			速度・セキュリティー関連のため一度プリ(前持った準備)する。コンパイルの前。プリコンパイルと言う。
//			速度→大型のサイトになると何度もログインなど大多数から繰り返されるため速度を上げたい。
//			セキュリティー→?に悪人が何かしらを入れるのを防ぐため
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

//										↓1番目の?に格納してください
			preparedStatement.setString(1, loginUserId);
//										↓2番目の?に格納してください
			preparedStatement.setString(2, loginPassword);


			ResultSet resultSet = preparedStatement.executeQuery();
//			nextについて
//			カーソルを現在の位置から順方向に1行移動します。ResultSetのカーソルは、初期状態では最初の行の前に位置付けられています。
//			nextメソッドの最初の呼出しによって、最初の行が現在の行になります。
//			2番目の呼出しによって2行目が現在の行になり、以下同様に続きます。
//			nextメソッドの呼出しでfalseが返されると、カーソルは最終行の後ろに位置します。
//			現在の行が必要なResultSetメソッドのあらゆる呼出しによって、SQLExceptionがスローされます。
//			結果セットのタイプがTYPE_FORWARD_ONLYである場合、
//			以降のnextの呼出しでJDBCドライバ実装がfalseを返すかSQLExceptionをスローするかは、そのベンダーによって指定されます。
////		現在の行で入力ストリームがオープンしている場合、nextメソッドへの呼出しは暗黙的にそのストリームをクローズさせます。
//			新しい行が読み込まれるときに、ResultSetオブジェクトの警告チェーンはクリアされます。
//			戻り値:
//			新しい現在の行が有効である場合はtrue、行がそれ以上存在しない場合はfalse
//			例外:
//			SQLException - データベース・アクセス・エラーが発生した場合、またはこのメソッドがクローズされた結果セットで呼び出された場合
			if(resultSet.next()) {
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));


				if(resultSet.getString("admin_flg").equals("1")) {
					loginDTO.setAdmin_flg(true);
				}

				}
//				equals→この文字列と指定されたオブジェクトを比較します。引数が"null"ではなく、
//				このオブジェクト(null)と同じ文字シーケンスを表すStringオブジェクトである場合にだけ、結果はtrueになります。
//				　　↓!は論理演算子の一種ですが直後の条件式や値のtrueとfalseを逆転させる機能を持っています。
				if(!(resultSet.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
	}
	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

}