package com.internousdev.ecsite.action;

import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{

	private String itemName;
	private int itemPrice;
	private int itemStock;
	private Map<String,Object> session;
	private ItemCreateCompleteDAO dao = new ItemCreateCompleteDAO();

	public String execute() throws SQLException {


		dao.createItem(session.get("itemName").toString(),
					   Integer.parseInt(session.get("itemPrice").toString()),
					   Integer.parseInt(session.get("itemStock").toString()));

		String result = SUCCESS;
		return result;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStoce(int itemStock) {
		this.itemStock = itemStock;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
