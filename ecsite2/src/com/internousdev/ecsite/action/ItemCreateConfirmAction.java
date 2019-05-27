package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware {

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;

		if(!(itemName.equals(""))
			&& !(itemPrice.equals(""))
			&& !(itemStock.equals(""))){
				session.put("itemName", itemName);
				session.put("itemPrice", itemPrice);
				session.put("itemStock",itemStock);
		}else {
			 setErrorMessage("未入力だよ♡");
			 result = ERROR;
		}
		return result;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}


}