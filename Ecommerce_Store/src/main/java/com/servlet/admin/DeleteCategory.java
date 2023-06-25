package com.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CategoryDao;
//maps the servlet to the URL "/admin/deleteCategory"
@WebServlet("/admin/deleteCategory")
public class DeleteCategory extends HttpServlet {

	@Override
	//overridden from the HttpServlet class, and it handles HTTP GET requests sent to the servlet
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		CategoryDao dao = new CategoryDao();

		HttpSession session = req.getSession();
		// a success message is set
		if (dao.deleteCategory(id)) {

			session.setAttribute("succMsg", "Delete sucesfully");
			resp.sendRedirect("category.jsp");
			// user is redirected to the "category.jsp" page

		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("category.jsp");
		}

	}

}
