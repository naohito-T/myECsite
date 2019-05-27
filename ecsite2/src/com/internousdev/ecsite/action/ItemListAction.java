package com.internousdev.ecsite.action;

import java.sql.SQLException;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;




public class ItemListAction extends ActionSupport implements SessionAware{

	private ItemListDAO itemListDAO = new ItemListDAO();

	private ArrayList<ItemInfoDTO> itemInfoList= new ArrayList<ItemInfoDTO>();
	private String message;
	private Map<String,Object> session;

	public String execute() throws SQLException {

		itemInfoList = itemListDAO.getItemInfo();
		String result = SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}


	public ArrayList<ItemInfoDTO> getItemInfoList(){
		return itemInfoList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}