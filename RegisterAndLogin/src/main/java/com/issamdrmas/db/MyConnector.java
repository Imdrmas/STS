package com.issamdrmas.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnector {
	
     private static String PATH = "jdbc:mysql://localhost:3306/RegisterAndLogin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
     private static String USER = "root";
     private static String PASS = "";
     private static Connection conn = null;
     
      public static Connection getConnection() {
    	  try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(PATH, USER, PASS);
			System.out.println("db connection successfully ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	  return conn;
      }

}
