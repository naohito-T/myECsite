package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;



public class ItemListDeleteCompleteAction extends ActionSupport {

	public String deleteFlg;

	private ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();
	private String message;

	public String execute() throws SQLException {



		if(deleteFlg == null) { //null→メモリを何も指さない。
			return ERROR;
		}else if(deleteFlg.equals("1")) { // ←deleteFlgが"1"と等しい場合。"1"はjspファイルから所得。
			dao.ItemListDelete(); //←deleteメソッドを呼び出して履歴の削除処理を行います。
		}
		String result = SUCCESS; // ←定数定義(変更されたくないから)
		return result; // ←SUCCESSを返す。


	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
