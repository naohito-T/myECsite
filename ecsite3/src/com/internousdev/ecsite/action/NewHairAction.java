package com.internousdev.ecsite.action;

import java.util.List;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite.dao.HairInfoDAO;
import com.internousdev.ecsite.dto.HairInfoDTO;

public class NewHairAction extends ActionSupport {

	private List<HairInfoDTO> hairInfoDTOList = new ArrayList<HairInfoDTO>();

	public String execute() {
		HairInfoDAO hairInfoDAO = new HairInfoDAO();
		hairInfoDTOList = hairInfoDAO.getHairInfoListAll();

		return SUCCESS;
	}

	public List<HairInfoDTO> getHairInfoDTOList(){
		return hairInfoDTOList;
	}
	public void setHairInfoDTOList(List<HairInfoDTO> hairInfoDTOList) {
		this.hairInfoDTOList = hairInfoDTOList;
	}
}
