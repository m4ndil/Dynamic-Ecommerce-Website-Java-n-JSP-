package com.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//maps the servlet to the URL "/admin/alogout"
@WebServlet("/admin/alogout")
//handles HTTP GET requests sent to the servlet.
public class AdminLogout extends HttpServlet {
	@Override
	
	//object is retrieved from the request object req
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("adminObj");
		session.setAttribute("succMsg", "Logout Successfully");
		resp.sendRedirect("../login.jsp");
	}
}
