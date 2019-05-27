package com.internousdev.ecsite.action;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private String password;

//	strutusから実行しなさいと言われるexecute()
	public String execute(){
		String result = ERROR;
//		dbのログインユーザーとフロントユーザーが入力した値が同じならDTOへ代入。	↓引数/この２つは↑のフィールドの値
		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",loginDTO);




//		入力値からユーザー情報の検索を行います。
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;

//			BuyItemDTO型のbuyItemDTO変数(ローカル変数。)範囲はこのメソッド内。
//			クラス定義による効果(クラスを定義すればJavaで利用可能な型の種類は増えていく。)
//			BuyItemDTOのクラスがあるためBuyItemDTOの型が使える(このようにクラスを定義することで利用可能になる型の事をクラス型という)
//			仮想世界に複数存在しうる同名のインスタンスの中から、特定の１つのインスタンスをプログラム的に識別するため
//			今回はBuyItemDTOを多数定義しているためプログラムが単一のBuyItemDTOを見つけるため利用。
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
//			ログイン認証が成功した場合、次の画面で商品情報が必要なため商品の情報を取得します。
//			画面が何度も遷移するためsessionに格納している。
//			sessionはcookieを利用している

			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());
			session.put("admin_flg", loginDTO.getAdmin_flg());
			System.out.println((boolean) session.get("admin_flg"));
			if(((boolean) session.get("admin_flg"))){
				result = "login";
				return result;
				}

//			↓SUCCESSをstrutsに返す
			return result;

		}
//		↓ERRORをstrutsに返す
		return result;
	}
//	↓ここからはjspファイルから入力された値を受け取るメソッド
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
