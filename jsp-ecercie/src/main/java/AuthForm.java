import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthForm extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException{
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(username.equals("admin") && password.equals("admin123"))
		{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
			request.setAttribute("username", username); 
			request.setAttribute("password", password);
			dispatcher.forward( request, response );
		}
		else {
		response.sendRedirect("error.jsp");
		}
		

		
		
	
		
}
}
