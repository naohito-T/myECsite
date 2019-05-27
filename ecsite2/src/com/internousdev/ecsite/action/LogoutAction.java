package com.internousdev.ecsite.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;


public class LogoutAction extends ActionSupport implements SessionAware {

	private Map<String,Object>session;
	public String execute() {
		session.clear(); //←マップからマッピングをすべて削除します(オプションの操作)。
		return SUCCESS;  //この呼出しが戻ると、マップは空になります。
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
