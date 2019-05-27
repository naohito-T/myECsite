package com.internousdev.ecsite.action;
//Map：キーと要素とのマッピングを表すデータ構造。
//	Listのようなインデックスの代わりに、キーで要素を識別します。
// Map<String(key),Object(要素の型)>要素の型にObjectを指定するとどんな型でも入れられる。
// どんな型でも入れられるが取り出す時型を忘れている。
// そのためtoStringなどで型を再度指定してして上げる

//java.utilとは
//コレクション・フレームワーク、レガシー・コレクション・クラス、イベント・モデル、
//日時機能、国際化、およびさまざまなユーティリティ・クラス
//(StringTokenizer、乱数ジェネレータ、およびビット配列)が含まれています。

import java.sql.SQLException;
import java.util.Map;
//org.apache.struts2.interceptorというパッケージ名のSessionAwareというクラスをインポートしている。
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite.dao.UserCreateCompleteDAO;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String,Object> session;
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

//	throws→メソッド内で例外が発生した場合、自身のメソッド内でcatchするのではなく呼ばれる側に例外を投げる処理。
	public String execute() throws SQLException {
//		"get"→指定されたキーがマップされている値を返します。
//		このマップにそのキーのマッピングが含まれていない場合はnullを返します。
		userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),
										 session.get("loginPassword").toString(),
										 session.get("userName").toString());
//		↑DAOを経由して入力された内容をDBに登録します。
//		UserCreateConfirmActionでMapに"key"と"値"は登録された。getメソッドはMapのメソッド。
		String result = SUCCESS;
		return result;
	}
//	jspファイルから転送されてくる。jspと連動。
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
