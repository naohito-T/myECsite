package com.internousdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
//	driverName→JDBCのドライバーの名前を変数に代入しています。ドライバーとはJavaとdbを繋げる工具箱。
	private static String driverName = "com.mysql.jdbc.Driver";
//	mysqlを使っているのでmysql用のÜRLの指定の仕方。
	private static String url = "jdbc:mysql://localhost/ecsite3";

	private static String user = "root";
	private static String password = "root";

//	接続状態にする
	public Connection getConnection(){
//		初期化し使える状態にする。
		Connection con = null;
//		上記の２つは接続しかしないクラス。公式として覚えておくと良い。
		try {
//			forName→指定された文字列名を持つクラスまたはインタフェースに関連付けられた、Classオブジェクトを返します。
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
