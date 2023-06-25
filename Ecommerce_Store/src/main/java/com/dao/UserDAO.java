package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAO {
	private Connection conn;
	
	// Constructor for the UserDao class to initialize the database connection
	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	//takes list of  user as input and inserts each order into the database 
	public boolean addUser(User user) {
		boolean f = false;
		try {
			String sql = "insert into user(full_name,email,mobno,password,address,city,state,pincode,image) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobNo());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getCity());
			ps.setString(7, user.getState());
			ps.setString(8, user.getPin());
			ps.setString(9, user.getImage());
			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//updates an existing user's information
	public boolean updateUser(User user) {
		boolean f = false;
		try {
			String sql = "update user set full_name=?,email=?,mobno=?,address=?,city=?,state=?,pincode=?,image=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobNo());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getCity());
			ps.setString(6, user.getState());
			ps.setString(7, user.getPin());
			ps.setString(8, user.getImage());
			ps.setInt(9, user.getId());

			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//checks if a user with a given email and password exists in the database
	public User login(String email, String password) {
		User user = null;
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobNo(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setCity(rs.getString(7));
				user.setState(rs.getString(8));
				user.setPin(rs.getString(9));
				user.setImage(rs.getString(10));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//retrieves a user's information given their ID
	public User getUser(int userId) {
		User user = null;
		try {
			String sql = "select * from user where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobNo(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setCity(rs.getString(7));
				user.setState(rs.getString(8));
				user.setPin(rs.getString(9));
				user.setImage(rs.getString(10));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//checks if an email is already in use
	public boolean checkEmail(String email) {
		boolean f = true;
		try {
			String sql = "select * from user where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//checks if a user's old password matches the one stored in the database
	public boolean checkOldPasssword(int id, String oldpass) {
		boolean f = false;
		try {
			String sql = "select * from user where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, oldpass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//updates a user's password in the database
	public boolean updateNewPasssword(int id, String newpass) {
		boolean f = false;
		try {
			String sql = "update user set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newpass);
			ps.setInt(2, id);
			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//checks if a given email and mobile number match those of a user in the database
	public boolean checkEmailAndMobForForgot(String email, String mobNo) {
		boolean f = false;
		try {
			String sql = "select * from user where email=? and mobno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, mobNo);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	// resets the password
	public boolean resetPasssword(String newpass, String email) {
		boolean f = false;
		try {
			String sql = "update user set password=? where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newpass);
			ps.setString(2, email);

			int a = ps.executeUpdate();

			if (a == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
