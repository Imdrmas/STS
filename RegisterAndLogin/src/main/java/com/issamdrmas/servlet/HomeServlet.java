package com.issamdrmas.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.issamdrmas.validation.Validator;

public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("gets into doGet ..1");
		//String servletPath = request.getServletPath();
		//String urlString   = request.getQueryString(); 
		request.getRequestDispatcher("index.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter();
        
		String username = request.getParameter("username").toLowerCase();
		String password = request.getParameter("password");
		
		if (Validator.checkUser(username, password)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
		
		doGet(request, response);

	}

}
