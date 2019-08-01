package com.issamdrmas.validation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.issamdrmas.db.MyConnector;


public class Validator {
	
	public static boolean checkUser(String username, String password) {
		boolean isOkey = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String strQuery = "SELECT `username`, `password` FROM `users` WHERE username=? AND password=?";
			PreparedStatement statement = MyConnector.getConnection().prepareStatement(strQuery);
			statement.setString(1,  username);
			statement.setString(2,  password);
			ResultSet res = statement.executeQuery();
			isOkey = res.next();
			System.out.println("Username And Password Are Valide ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isOkey;
		
	}
	
	public static void register(String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String strInsert = "INSERT INTO users VALUES(?,?)";
			PreparedStatement statement = MyConnector.getConnection().prepareStatement(strInsert);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
