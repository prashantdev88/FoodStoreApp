package com.foodstore.dao.jdbcimpl;


import com.foodstore.utility.DBConnection;
import com.foodstore.dao.User_Dao;
import com.foodstore.pojo.User_pojo;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoJDBCimpl implements User_Dao {

	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sqlQuery = null;
	
	
	public boolean add(User_pojo user) throws Exception {
		
		con = DBConnection.getDBConn();
		
		sqlQuery = "insert into user (First_Name,Last_Name,Type,User_Email,User_Password,User_Address) values(?,?,?,?,?,?)";
		pstm = con.prepareStatement(sqlQuery);
		pstm.setString(1,user.getFirst_Name());
		pstm.setString(2,user.getLast_Name());
		pstm.setString(3,user.getType());
		pstm.setString(4,user.getUser_Email());
		pstm.setString(5,user.getUser_Password());
		pstm.setString(6,user.getUser_Address());
		
		int i = pstm.executeUpdate();
		DBConnection.closeCon();
		if(i>0) {
			return true;
		}
		return false;		
	}

	public boolean update(User_pojo user) throws Exception {
		
		con = DBConnection.getDBConn();
		sqlQuery = "update user set First_Name=?,Last_Name=?,Type=?,User_Email=?,User_Password=?,User_Address=? where User_Id=?";
		pstm = con.prepareStatement(sqlQuery);
		pstm.setString(1,user.getFirst_Name());
		pstm.setString(2,user.getLast_Name());
		pstm.setString(3,user.getType());
		pstm.setString(4,user.getUser_Email());
		pstm.setString(5,user.getUser_Password());
		pstm.setString(6,user.getUser_Address());
		pstm.setInt(7,user.getUser_Id());
		int i = pstm.executeUpdate();
	DBConnection.closeCon();
		if(i>0) {
			return true;
		}		
		return false;
	}

	public boolean delete(int user_Id) throws Exception {
		con = DBConnection.getDBConn();
		sqlQuery = "delete from user where User_Id=?";
		pstm = con.prepareStatement(sqlQuery);
		pstm.setInt(1,user_Id);
		int i = pstm.executeUpdate();
		DBConnection.closeCon();
		if(i>0) {
			return true;
		}
		return false;
	}

	public List<User_pojo> all() throws Exception {
		
		List<User_pojo> userList = new ArrayList<User_pojo>();
		con = DBConnection.getDBConn();
		sqlQuery = "select * from foodapp.user";
		pstm = con.prepareStatement(sqlQuery);
		rs = pstm.executeQuery();
		while(rs.next()) {
			User_pojo user = new User_pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			userList.add(user);	
		}
		DBConnection.closeCon();		
		return userList;
	}

	public User_pojo getById(int User_Id)throws Exception {
		con = DBConnection.getDBConn();
		sqlQuery = "select * from user where User_Id=?";
		pstm = con.prepareStatement(sqlQuery);
		pstm.setInt(1, User_Id);
		rs = pstm.executeQuery();
		while(rs.next()) {
			User_pojo user = new User_pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			return user;
		}
		
		return null;
	}

	public List<User_pojo> getByFirstName(String First_Name)throws Exception {
		List<User_pojo>userList = new ArrayList<User_pojo>();
		con = DBConnection.getDBConn();
		sqlQuery=  "select * from user where First_Name=?";
		pstm = con.prepareStatement(sqlQuery);
		pstm.setString(1, First_Name);
		rs = pstm.executeQuery();
		while(rs.next()) {
			User_pojo user = new User_pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			userList.add(user);
		}
		return userList;
	}

	public List<User_pojo> sortByFirstName(boolean flag)throws Exception {
		List<User_pojo>userList = new ArrayList<User_pojo>();
		con = DBConnection.getDBConn();
		if(flag == true) {
		sqlQuery = "select * from user order by First_Name asc";
		}else {
			sqlQuery = "select * from user order by First_Name desc";
		}
		pstm = con.prepareStatement(sqlQuery);
		rs = pstm.executeQuery();
		while(rs.next()) {
			User_pojo user = new User_pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			userList.add(user);
		}
		return userList;
	}

	public List<User_pojo> sortByLastName(boolean flag) throws Exception{
		List<User_pojo> userList = new ArrayList<User_pojo>();
		con = DBConnection.getDBConn();
		if(flag==true) {
			sqlQuery="select * from user order by Last_Name asc";
		}else {
			sqlQuery="select * from user order by Last_Name desc";
		}
		pstm = con.prepareStatement(sqlQuery);
		rs = pstm.executeQuery();
		while(rs.next()) {
			User_pojo user = new User_pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			userList.add(user);
		}
		return userList;
	}

	public User_pojo userLogin(String User_Email, String User_Password) throws Exception {
		con = DBConnection.getDBConn();
		sqlQuery = "select * from user where User_Email=? AND User_Password=?;";
		pstm = con.prepareStatement(sqlQuery);
		pstm.setString(1, User_Email);
		pstm.setString(2, User_Password);
		rs = pstm.executeQuery();
		while(rs.next()) {
			User_pojo user = new User_pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			return user;
		}
		return null;
		
	}
}
