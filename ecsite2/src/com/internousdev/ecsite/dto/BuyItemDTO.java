package com.internousdev.ecsite.dto;

public class BuyItemDTO {

//	テーブルカラムに対応したフィールド変数を宣言します。
	private int id;
	private String itemName;
	private String itemPrice;

//	フィールド変数に対応したgetter/setterを定義します。
// getはメソッド //setはコンストラクタ
	public String getItemName() { //{}の中をメソッドブロックという。
		return itemName;
	}								//↓仮引数
	public void setItemName(String itemName) {//{}の中をメソッドブロックという。
		this.itemName = itemName;
	}
	public String getItemPrice() { //{}の中をメソッドブロックという。
		return itemPrice;
	}								//↓仮引数
	public void setItemPrice(String itemPrice) { //{}の中をメソッドブロックという。
		this.itemPrice = itemPrice;
	}
	public int getId() {
		return id;
	}					//↓仮引数
	public void setId(int id) { //{}の中をメソッドブロックという。
		this.id = id;
	}
	//setメソッドはコンストラクタ。フィールドの初期値に値を挿入したいため。
	//コンストラクタは必ずクラス名と同じである必要があり、またメソッドと違い戻り値を指定することができない。

}
