package com.issamdrmas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.issamdrmas.db.MyConnector;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private static String PATH = "jdbc:mysql://localhost:3306/RegisterAndLogin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 
		    String username = request.getParameter("username").toLowerCase();
			String password = request.getParameter("password");
			String pswRepeat = request.getParameter("psw-repeat");
        
		try {
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String strQuery = "SELECT `username` FROM `users` WHERE username='"+username+"'";
			PreparedStatement statement = MyConnector.getConnection().prepareStatement(strQuery);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				String userStr = res.getString("username");	
				if (username.equals(userStr)) {
					out.println("This username is exist or");
				}
		
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
		if (!pswRepeat.equals(password)) {
			out.println("Password not match");
		} else {
		
		try {
		    Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(PATH,"root","");
			PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES(?,?)");
			
		
			ps.setString(1, username);
			ps.setString(2, password);
			
			int i = ps.executeUpdate();
			if (i > 0) {
				out.println("You are successfully registered");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);
			} else {
				out.println("You are not unsuccessfully registered");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
		
	}}

