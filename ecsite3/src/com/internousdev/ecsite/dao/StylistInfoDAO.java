package com.internousdev.ecsite.dao;

import com.internousdev.ecsite.dto.StylistInfoDTO;
import com.internousdev.ecsite.util.DBConnector;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class StylistInfoDAO {

	//stylist一覧ページ
	public List<StylistInfoDTO> getStylistInfoAll(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<StylistInfoDTO> stylistInfoDTO = new ArrayList<StylistInfoDTO>();
		String sql = "SELECT * FROM stylist_info";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StylistInfoDTO stylistInfo = new StylistInfoDTO();
				stylistInfo.setId(rs.getInt("id"));
				stylistInfo.setStylistId(rs.getInt("stylist_id"));
				stylistInfo.setStylistName(rs.getString("stylist_name"));
				stylistInfo.setStylistDescription(rs.getString("stylist_description"));
				stylistInfo.setImageFilePath(rs.getString("image_file_path"));
				stylistInfo.setImageFileName(rs.getString("Image_file_name"));
				stylistInfoDTO.add(stylistInfo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stylistInfoDTO;
	}
	//stylist詳細ページ
	public StylistInfoDTO getStylistInfoByHairId(int hairId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		StylistInfoDTO stylistInfoDTO = new StylistInfoDTO();
		String sql = "SELECT * FROM stylist_info where hair_id=?";
		try {

		}
	}
}
