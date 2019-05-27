package com.internousdev.ecsite.action;

//	actionメソッドはsturts/jspとやり取りするためにActionSupportを実装
//	購入商品はこちらでよろしいですか。ユーザーから了承得られActionが作動する。
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import java.sql.SQLException;
import java.util.Map;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;

//	dbへアクセスするインスタンスを生成。
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException { //←import java.sqlをimportをしているため使用できる。
		buyItemCompleteDAO.buyItemInfo( //←ここで引数にし渡している(String型にして)
//				セッションから取得した商品情報をDAOのbuyItemInfoメソッドに渡しています。
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());
//							↓定数定義
			String result = SUCCESS;
//			↓strutsへ返す。
			return result;

	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}


}
