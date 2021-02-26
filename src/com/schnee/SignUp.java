package com.schnee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.schnee.dao.LoginDAO;
import com.schnee.dao.SignUpDAO;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
	SignUpDAO dao = new SignUpDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("un");
		String pw = request.getParameter("pw");
		
		if(dao.createCredentials(un, pw)){
			HttpSession session = request.getSession();
			session.setAttribute("un", un);
			session.setAttribute("pw", pw);
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
		
	}

}
