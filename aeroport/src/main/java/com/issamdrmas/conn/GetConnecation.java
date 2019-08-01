package com.issamdrmas.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnecation extends SqlContext {

	public static Connection getMyConnection() throws Exception {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/springbootdb" + "?useUnicode=true&characterEncoding=UTF-8";
			con = DriverManager.getConnection(URL, "", "");
			System.out.println("Connected");

		} catch (Exception e) {
			System.out.println("Unconnected" + e);
		}
		return con;
	}

	public static void closeDb() {
		try {
			if (resultSet != null) {
				resultSet.close();
				resultSet = null;
			}
			if (statement != null) {
				statement.close();
				statement = null;
			}
			if (preparedStatement != null) {
				preparedStatement.close();
				preparedStatement = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
      }

}
