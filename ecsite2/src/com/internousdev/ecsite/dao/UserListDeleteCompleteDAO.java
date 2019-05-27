package com.internousdev.ecsite.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public void delete() throws SQLException {

		String sql = "DELETE FROM login_user_transaction";
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
