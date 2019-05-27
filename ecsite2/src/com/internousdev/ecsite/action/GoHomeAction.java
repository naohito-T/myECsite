package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class GoHomeAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;

	public String execute() {
//		SUCCESSが大文字の理由は変数ではなく定数を定義したいから。定数だと他者から変更できない。
		return SUCCESS;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
//	Javaで扱うすべての変数は必ず何らかの型(type)を持っています。今まで利用してきた"整数を入れるためのint型や"
//	"文字列を入れるためのString型"はJavaが"標準"で準備しておりいつでも使える型。それに加えクラスを定義すれば
//	Javaで利用可能な型の種類はどんどん増えていく
//	クラス型変数を用いる理由。
//	仮想世界に複数存在しうる同名のインスタンスの中から、特定の１つのインスタンスをプログラム的に識別するため

//	ローカル変数の独立性
//	異なるメソッドに属するローカル変数は、お互いに独立していて無関係



}
