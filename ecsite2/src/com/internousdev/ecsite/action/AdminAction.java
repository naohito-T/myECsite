package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
//Home.jspの新規ユーザー作成から実行され入力値が飛んでくる。
//ActionSupportクラスによりページの遷移が実行される。本来ならサーバーサイドのServletを使用するが今回はStrutsを使用。


public class AdminAction extends ActionSupport {
//	移動するページadmin.jspのためstrutsのadminへ返す。


	public String execute() {
		return SUCCESS;
	}

}