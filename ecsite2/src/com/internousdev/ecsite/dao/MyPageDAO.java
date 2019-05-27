package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
//	dbから購入履歴を取得するためのメソッドです。
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id)throws SQLException {
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
//		LEFT JOINを用いて複数のテーブルを結合することによってユーザー情報と履歴情報を紐づけて一括して取得することができる。
//		LEFT JOINで一つを主体にし結合する。

//      表示の順番→item_info_transaction 買ったもの,値段,購入個数,支払い方法,insert_date
		String sql = "SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY insert_date DESC";

		try {
//			プリコンパイルの準備。コンパイル前に格納する。
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			?に一つずつ格納していく。
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, user_master_id);
//			格納したのを実行。ResultSetの戻り値を取得。
			ResultSet resultSet = preparedStatement.executeQuery();//←Query()なのはdbを変更・更新せず。参照のため。
//			取得した結果を１件ずつDTOに格納し、更にDTOをArrayListに格納しています。
			while(resultSet.next()){
				MyPageDTO dto = new MyPageDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setTotalCount(resultSet.getString("total_count"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				myPageDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally { //例外があっても必ず行いたい処理。
			connection.close();
		}
		return myPageDTO;
	}
//	dbから購入履歴を削除するためのメソッド。MyPageActionから呼び出される。
	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException {
		String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id = ?";
		PreparedStatement preparedStatement; //PreparedStatement型の変数を定義。初期化せず。
		int result = 0; //result変数を定義し初期化する。

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, user_master_id);
			result = preparedStatement.executeUpdate(); //Updateはdbを更新する。
		}catch (SQLException e){
			e.printStackTrace();
		}finally {  //finallyブロックは例外がおきる・おきないに関わらずそのメソッド内で最後に必ず処理が行われるブロックです。
			connection.close(); //メソッド内に一致するcatch文がなかったとしてもfinallyブロックだけは必ず処理される事になっています。
		}						//例外の発生に関わらずそのメソッド内で必ず行っておきたい重要な処理がある場合にfinallyを使用する。
		return result; //MyPageActionへ削除した件数を返します。
	}

}

