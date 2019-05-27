package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
//	Connection型のconnection変数。
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "INSERT INTO login_user_transaction(login_id,login_pass,user_name,insert_date) VALUES(?,?,?,?)";

	public void createUser(String loginUserId,String loginUserPassword,String userName) throws SQLException {
//		throwsはユーザーへエラーを出すためでcatchしなくてよいのかと思っていたが、今回はcatchが出ている。
		try { // PreparedStatement→プリコンパイルの準備。
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,loginUserId);
			preparedStatement.setString(2,loginUserPassword);
			preparedStatement.setString(3,userName);
			preparedStatement.setString(4, dateUtil.getDate());
//			指定されたパラメータを指定されたJavaのString値に設定します。データベースに送るときに、
//			ドライバはこれをSQL VARCHARまたはLONGVARCHAR値(ドライバのVARCHAR値の制限に対する引数のサイズに依存)に変換します。
			preparedStatement.execute();
//			execute()→このPreparedStatementオブジェクトの、あらゆる種類のSQL文を実行します。
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

		}connection.close();
	}
}