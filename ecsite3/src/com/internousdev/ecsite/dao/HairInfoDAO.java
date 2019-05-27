package com.internousdev.ecsite.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.dto.HairInfoDTO;


public class HairInfoDAO {

	//hair一覧ページ
	public List<HairInfoDTO> getHairInfoListAll(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<HairInfoDTO> hairInfoDTOList = new ArrayList<HairInfoDTO>();
		String sql = "select * from hair_info";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HairInfoDTO hairInfoDTO = new HairInfoDTO();
				hairInfoDTO.setId(rs.getInt("id"));
				hairInfoDTO.setHairId(rs.getInt("hair_Id"));
				hairInfoDTO.setHairDiscription(rs.getString("hair_description"));
				hairInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				hairInfoDTO.setImageFileName(rs.getString("image_file_name"));
				hairInfoDTOList.add(hairInfoDTO);
 			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hairInfoDTOList;
	}

	//hair詳細ページ
	public HairInfoDTO getHairInfoByHairId(int hairId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		HairInfoDTO hairInfoDTO = new HairInfoDTO();
		String sql = "SELECT * FROM hair_info WHERE hair_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,hairId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hairInfoDTO.setId(rs.getInt("id"));
				hairInfoDTO.setHairId(rs.getInt("hair_id"));
				hairInfoDTO.setHairDiscription(rs.getString("hair_discription"));
				hairInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				hairInfoDTO.setImageFileName(rs.getString("image_file_name"));
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
		return hairInfoDTO;
	}
}
