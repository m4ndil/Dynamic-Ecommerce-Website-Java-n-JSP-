package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Category;
import com.util.DBConnect;

public class CategoryDao {

	private Connection conn;
	// Constructor for the CategoryDao+ class to initialize the database connection
	public CategoryDao() {
		conn = DBConnect.getConnection();
	}
	// Method to add a new category
	public boolean addCategory(String title, String image) {
		boolean f = true;
		try {
			String sql = "insert into category(title,image) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, image);

			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	// Method to update category
	public boolean updateCategory(String title, String image, int id) {
		boolean f = true;
		try {
			String sql = "update category set title=?,image=? where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, image);
			ps.setInt(3, id);

			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	// Method to delete category
	public boolean deleteCategory(int id) {
		boolean f = true;
		try {
			String sql = "delete from category where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	// Method to get all of the category
	public List<Category> getCategory() {
		Category cat = null;
		List<Category> list = new ArrayList<Category>();
		try {

			String sql = "select * from category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cat = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	// Method to get category by id number
	public Category getCategoryById(int id) {
		Category cat = null;

		try {

			String sql = "select * from category where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cat = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cat;
	}
}
