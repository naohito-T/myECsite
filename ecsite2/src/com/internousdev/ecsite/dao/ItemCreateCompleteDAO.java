package com.internousdev.ecsite.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil du = new DateUtil();
	private String sql = "INSERT INTO item_info_transaction(item_name,item_price,item_stock,insert_date) VALUE(?,?,?,?)";


	public void createItem(String itemName,int itemPrice,int itemStock) throws SQLException {

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setInt(2, itemPrice);
			ps.setInt(3, itemStock);
			ps.setString(4,du.getDate());

			ps.execute();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}


}
