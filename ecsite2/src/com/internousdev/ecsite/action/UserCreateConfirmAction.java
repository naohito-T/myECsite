package com.internousdev.ecsite.action;

//userCreate.jspから入力された値で実行されるActionファイル

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
//	このクラスのフィールド定義(性格)
//  ↓フィールド値はuserCreate.jspから送信された値。フィールド値とuserCreate.jspのname=""の値は同じにする。
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String,Object> session;
	private String errorMessage;

//	メソッド定義。strutsから呼び出されるメソッド
	public String execute() {
		String result = SUCCESS;
//		未入力項目の有無を確認しています。
//		equals→この文字列と指定されたオブジェクトを比較します。
//		引数がnullではなく、このオブジェクトと同じ文字シーケンスを表すStringオブジェクトである場合にだけ、
//		結果はtrueになります。trueしか返さない要素。空欄がtrueになるのはおかしいため！で結果を逆転している。
		if(!(loginUserId.equals(""))
			&& !(loginPassword.equals(""))
			&& !(userName.equals(""))) {
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
//			↑ここでMapのObject型に値を代入している(userCreate関連で何度も使用。)
		}else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
 		}
//		結果をjspファイルに返す。
		return result;
	}
//  ↓メソッドのsetはjspファイルのnameと対応している。jspファイルのname=""とメソッドの引数は同じ名称にし合わせる。
//  ページの受け渡しはstrutsが担当。本来ならServletが担当しているが記述が長くなるためstrutsで対応している。
// strutsの箱velueStackにjspファイルの値が入りサーバーサイドのActionファイルへ値が届く。
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
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}



}
