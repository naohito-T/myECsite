package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;


public class MyPageAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
//	List: 複数の要素の順番を保持する。インデックス(0,1,2,3,と配列の番号)を利用して
//	要素にアクセスするため、要素の代わりとして利用することができる。
//	※後から要素を追加・変更することができるのが特徴。
//	ArrayList→要素へのアクセス：高速 要素の途中追加・削除：低速
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
//		!は論理演算の一種ですが直後の条件式や値のtrueとfalseを逆転させる機能を持っています。
//		containsKey→指定のキーのマッピングがこのマップに含まれている場合に"true"を返します。

		if(!session.containsKey("id")) {
			return ERROR; // ←idと等しくない場合ERROR。
		}
//		履歴の削除がされているか否か、チェックをしています。
		if(deleteFlg == null) { //null→メモリを何も指さない。
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();
//			dbから取得した履歴情報を"myPageList"に格納しています。
			myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);
		}else if(deleteFlg.equals("1")) { // ←deleteFlgが"1"と等しい場合。"1"はjspファイルから所得。
			delete(); //←deleteメソッドを呼び出して履歴の削除処理を行います。
		}
		String result = SUCCESS; // ←定数定義(変更されたくないから)
		return result; // ←SUCCESSを返す。
	}
//	履歴の削除を行うためのメソッドです。
	public void delete() throws SQLException {
		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();
//		res→resultの略。簡易的に作った変数。myPageDAOのbuyItemHistoryDeleteメソッド(削除メソッド)
//		に引数でString型のitem_transaction_idとuser_master_idを与えdbより取得。
		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);
//		"1件以上削除されたか"否かで正常に削除処理がされたか判断しています。
		if(res > 0) {
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public ArrayList<MyPageDTO> getMyPageList(){
		return this.myPageList;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
