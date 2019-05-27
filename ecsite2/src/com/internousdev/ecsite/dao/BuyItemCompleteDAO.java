package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {
//				↓BuyItemConfirmActionから呼び出され引数で値をもらう。
	public void buyItemInfo(String item_transaction_id,String total_price,String total_count,
			String user_master_id,String pay) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();

//		user_buy_item_transactionのテーブルの中へデータを挿入してください。
		String sql = "INSERT INTO user_buy_item_transaction"
				+ "(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date)"
				+ "VALUES(?,?,?,?,?,?)";
//		内的・外的の要因でエラーが出る可能性があるためここに記載し格納しておく。
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2, total_price);
			preparedStatement.setString(3, total_count);
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6,dateUtil.getDate());
//			↑現在日時を取得しています
			preparedStatement.execute();
//			setString→指定されたパラメータを指定されたJavaのString値に設定します。データベースに送るときに、
//			ドライバはこれをSQL VARCHARまたはLONGVARCHAR値(ドライバのVARCHAR値の制限に対する引数のサイズに依存)に変換します。

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}

	}

}
