package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//pecifies the URL pattern for which this servlet is mapped to handle
@WebServlet("/ulogout")

//used to handle user logout requests in a web application
public class LogoutUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("userObj");
		session.setAttribute("succMsg", "Logout Successfully");
		resp.sendRedirect("login.jsp");
	}
}
