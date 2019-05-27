package com.internousdev.ecsite.dto;
//メソッドに同じ名前をつける事はできない。
//同じメソッドを定義することをオーバーロード(または多重定義と言う)

public class LoginDTO {

	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;
	private boolean admin_flg = false;

//	getメソッドはLoginActionのsessionメソッドにより値を受け取っている

	public String getLoginId() {
		return loginId; //←returnの後ろに書かれた値を呼び出し元に戻す事ができる。
						//変数を戻すには"return: 変数名;"のように変数名を指定する
						//変数名は何でもよい。
	}								//↓仮引数
	public void setLoginId(String loginId) {
		this.loginId = loginId;
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
	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
	public boolean getAdmin_flg() {
		return admin_flg;
	}
	public void setAdmin_flg(boolean admin_flg) {
		this.admin_flg = admin_flg;
	}

}
