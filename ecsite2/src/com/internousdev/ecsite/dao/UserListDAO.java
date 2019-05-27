package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.UserInfoDTO;
import java.util.ArrayList;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();


	public ArrayList<UserInfoDTO> getUserInfo() throws SQLException {

		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();

		String sql = "SELECT login_id, user_name FROM login_user_transaction ORDER BY insert_date DESC";

		try {
			PreparedStatement pr = con.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();

			while(rs.next()) {
				UserInfoDTO dto = new UserInfoDTO();
				dto.setLoginId(rs.getString("login_Id"));
				dto.setUserName(rs.getString("user_name"));
				userInfoDTO.add(dto);//ArrayListに格納。
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return userInfoDTO;
	}
}
