package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;
import com.util.DBConnect;

public class CartDAO {
	private Connection conn;
	

	// Constructor for the CartDAO class to initialize the database connection
	public CartDAO() {
		conn = DBConnect.getConnection();
	}

	// Method to add a new item to the cart
	public boolean addCart(int pId, int userId) {
		boolean f = false;
		try {
			String sql = "insert into cart(product_id,user_id,quantity) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pId);
			ps.setInt(2, userId);
			ps.setInt(3, 1);
			// Executing the query and getting the number of affected rows
			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	// Method to check if an item already exists in the cart
	public boolean checkCart(int pId, int userId) {
		boolean f = false;
		try {
			// SQL query to select a record from the cart table
			String sql = "select * from cart where product_id=? and user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pId);
			ps.setInt(2, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	// Method to count the number of items in the cart
	public int countCart(int userId) {
		int i = 0;
		try {
			String sql = "select * from cart where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	// Method to get all the items in the cart for a particular user
	public List<Cart> getCart(int userId) {
		List<Cart> list = new ArrayList<Cart>();
		Cart cart = null;
		try {
			String sql = "select * from cart where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cart = new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				list.add(cart);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	// Method to update the quantity of an item in the cart
	public boolean updateQuantity(String sql) {
		boolean f = false;
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	// Method to delete the quantity of an item in the cart
	public boolean deleteCart(int id) {
		boolean f = false;
		try {
			String sql = "delete from cart where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
