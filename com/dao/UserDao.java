package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DbConnection.DbConn;
import com.entity.Users;

public class UserDao {
	
	private Connection conn;
	
	public UserDao(Connection conn) {
	super();
	this.conn=conn;
	}
	
	public static boolean registerUser(Users u) {
		boolean f=false;
		
    String sql="insert into users (name,email,password) values(?,?,?) ";
    try {
		PreparedStatement ps= DbConn.getConn().prepareStatement(sql);
		ps.setString(1, u.getName());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassword());
		
		int rows=ps.executeUpdate();
		if(rows==1) {
			f=true;
		}
	} 
    catch (SQLException e) {
		
		e.printStackTrace();
	}
		return f;
	}
	
	public   Users loginUser(String e, String p) {
		Users u=null;
		
		PreparedStatement ps;
		try {
			ps = DbConn.getConn().prepareStatement("select * from users where email = ? and password = ?");
			ps.setString(1, e);
			ps.setString(2, p);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				u=new Users();
				u.setId(1);
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
			 
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		
		return u;
	}
	
	
	
	public static boolean duplicacy(Users u){
		boolean flag=false;
		PreparedStatement ps;
		try {
			ps = DbConn.getConn().prepareStatement("select * from users where email = ?");
			ps.setString(1, u.getEmail());
			
			ResultSet RS=ps.executeQuery();
			
			if(RS.getString("email").equals(u.getEmail())) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return flag;
		
		
	
	}

}
