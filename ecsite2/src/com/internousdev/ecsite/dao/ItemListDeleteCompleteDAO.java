package com.internousdev.ecsite.dao;

import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

import java.sql.PreparedStatement;
import java.sql.Connection;

public class ItemListDeleteCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public void ItemListDelete()throws SQLException{

		String sql = "DELETE FROM item_info_transaction";
		PreparedStatement pr;

		try {
			pr = con.prepareStatement(sql);
			pr.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}

}
