package com.internousdev.ecsite.action;

import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;


public class UserListDeleteCompleteAction extends ActionSupport {

	private String deleteFlg;
	private UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();



	public String execute() throws SQLException {

		if(deleteFlg.equals("1")) {
			dao.delete();
		}
		return SUCCESS;



	}
	public String getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg) {

		this.deleteFlg = deleteFlg;
	}

}
