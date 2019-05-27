package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo() {
//		item_info_transactionテーブルのid,item_name,item_priceを参照しString型のsqlに代入。
//		商品情報を全て取得するSQL文を書きます。
		String sql = "SELECT id,item_name,item_price FROM item_info_transaction";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//		executeQuery()→このPreparedStatementオブジェクトのSQLクエリーを実行し、
//					　　そのクエリーによって生成されたResultSetオブジェクトを返します→select文で使用(更新したりdbを変更しないから)
			ResultSet resultSet = preparedStatement.executeQuery(); //	←SQL文を実行します。

			if(resultSet.next()) {   // ←resultSetで返ってきた結果をnext()メソッドで選択される。if文の条件式には真意値を加える必要があり
//				dbから取得した情報をDTOクラスに格納しています。　　　　　　　　　　next()メソッドには→の先に物があればtrueを返す。なければfalse
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name")); //←実引数
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}
		}catch(Exception e) {
//			java.lang.ThrowableクラスのprintStackTrace()メソッドを使用しエラー文を出力。
//			Throwableクラスは、Java言語のすべてのエラーと例外のスーパー・クラスです。
			e.printStackTrace();
		}
//		ActionクラスにDTOクラスを返します
		return buyItemDTO;
	}
}
