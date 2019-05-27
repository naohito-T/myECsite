package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	public String execute() {
		String result = "login";
//					指定↓したキーが存在するか確認を行いキーが存在する場合は"true"を返す
			if(session.containsKey("id")) {
				BuyItemDAO buyItemDAO = new BuyItemDAO();
//										buyItemDAO(detabase接続用)の↓メソッドを使用しDTOへ代入
				BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
//				DBから取得した商品情報をセッションに格納している(putメソッドはMapのメソッド)
				session.put("id", buyItemDTO.getId());
				session.put("buyitem_name", buyItemDTO.getItemName());
				session.put("buyItem_price", buyItemDTO.getItemPrice());
				result = SUCCESS;
			}
		return result;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}

}
