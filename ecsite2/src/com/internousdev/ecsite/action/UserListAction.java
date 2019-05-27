package com.internousdev.ecsite.action;

import java.sql.SQLException;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;


public class UserListAction extends ActionSupport implements SessionAware {

	private UserListDAO dao = new UserListDAO();

	private ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
	private Map<String,Object> session;
	private String message;

	public String execute() throws SQLException {

		userInfoDTO = dao.getUserInfo();
		String result = SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public ArrayList<UserInfoDTO> getUserInfoDTO(){ //jspファイルに返す。
		return userInfoDTO;
	}

	public String getMessage() { //jspファイルに返す。
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
