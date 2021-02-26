package com.schnee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.schnee.dao.LoginDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	LoginDAO dao = new LoginDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("un");
		String pw = request.getParameter("pw");
		
		if(dao.checkCredentials(un, pw)){
			HttpSession session = request.getSession();
			session.setAttribute("un", un);
			session.setAttribute("pw", pw);
			response.sendRedirect("welcome.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
		
	}

}
