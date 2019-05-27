package com.internousdev.ecsite.action;
//LoginしHomeからボタンを押し遷移した画面。

//Integer→	Javaで利用できる型は大きく基本データ型(int)と参照型(String)がある。
//			JavaのAPIにはそれぞれの基本データに対応したクラスを準備しており
//			それらはラッパークラスと総称されている。
//Integerは"java.lang.Integer(ラッパークラス)"のクラスであり、メソッドで"parseInt()"がある。
//これらの便利メソッドはいずれも静的メソッド"(static)"で宣言されているためラッパークラスを"インスタンスすることなく"手軽に利用できる。

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;
//implements→ インターフェイスを継承してクラスを定義することを「インターフェイスを実装する」と言う。
//実装には、クラスを定義する際にimplememntsキーワードを付けて実装元を指定します。
//実装では、インターフェイスで定義されたメソッドをすべて実装していないと、"コンパイルエラー"となる。

//既存のクラス(スーパークラス(ActionSupport)から新しいクラス(サブクラス(BuyItemAction)を作成する。

			//↓サブクラス	をスーパーから継承し	↓スーパークラス  ↓import(ルール)する
public class BuyItemAction extends ActionSupport implements SessionAware { //受け継いだメンバ(strutsのActionSupport)
	public Map<String,Object> session;									   //については記述する必要はありません。そのため
	private int count;													   //BuyItemActionでは独自のメソッドを記述すればよいのです。
	private String pay;

	public String execute(){

		String result = SUCCESS;
		session.put("count",count);
//		parseInt→int型に変換してくれるメソッド(数字の文字列をint型に変更してくれる)。引数はString型の数字でないといけない。
//		↓今回はdbから取り出している値をint型に変更している。Mapに格納されているObject型を取り出しているため型をもう一度決めないといけない。
//		parseIntは引数がString型でないとint型へ変更できないため一度toString()でString型に変更。Object型に挿入すると本来の型を忘れる。
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
//		↑Mapから取り出す時は"key"の指定でよろしい。
//		↓取り出した値を * 再度Mapの"total_price"型に代入している。
		session.put("total_price",intCount * intPrice);
//		ここでString型のpaymentを定義する。
		String payment;
//		"1"と等しかったら現金払い(デフォルトで1に指定されている(jspで"1"に指定されている(checkedで))
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay",payment);
		}else{ //それ以外をユーザーが選択した場合はクレジットカード払いとみなす。
			payment = "クレジットカード";
			session.put("pay",payment);
		}
		return result;
	}
	public void setCount(int count){
		this.count = count;
	}
	public void setPay(String pay){
			this.pay = pay;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}


}
