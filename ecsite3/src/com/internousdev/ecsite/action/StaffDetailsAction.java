package com.internousdev.ecsite.action;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite.dao.HairInfoDAO;
import com.internousdev.ecsite.dao.StylistInfoDAO;
import com.internousdev.ecsite.dto.StylistInfoDTO;


public class StaffDetailsAction extends ActionSupport {

	private int id;
	private int hairId;
	private int stylistId;
	private String stylistName;
	private String stylistdescription;
	private String imageFilePath;
	private String imageFileName;
	private List<StylistInfoDTO> stylistInfoDTO;
	private StylistInfoDTO stylistsInfoDTO = new StylistInfoDTO();

	public String execute(){

		//担当したスタッフ情報(hair一覧画面から渡されるhairIdを引数にして)
		StylistInfoDAO stylistInfoDAO = new StylistInfoDAO();
		stylistsInfoDTO = stylistInfoDAO.getStylistInfoByHairId(hairid);


	}
}
