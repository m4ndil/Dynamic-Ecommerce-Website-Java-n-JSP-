package com.servlet.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.CategoryDao;
import com.entity.Category;

//enable the handling of multipart/form-data requests, which allows file uploads
@MultipartConfig
@WebServlet("/admin/add_cat")

//handles the addition of a new category by extracting the values from the request parameters
public class AddCategory extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		Part p = req.getPart("img");
		String fileName = p.getSubmittedFileName();

		Category cat = new Category(title, fileName);

		CategoryDao dao = new CategoryDao();
		HttpSession session = req.getSession();

		//add the category to the database
		if (dao.addCategory(title, fileName)) {
			String path = req.getServletContext().getRealPath("") + "data" + File.separator + "img" + File.separator
					+ "category_img" + File.separator + fileName;
			/* System.out.println(path); */
			File file = new File(path);
			p.write(path);
			//he method saves the image file to the server and redirects the user 
			session.setAttribute("succMsg", "Added successfully");
			resp.sendRedirect("category.jsp");
			
			//redirects the user back
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("category.jsp");
		}

	}

}
