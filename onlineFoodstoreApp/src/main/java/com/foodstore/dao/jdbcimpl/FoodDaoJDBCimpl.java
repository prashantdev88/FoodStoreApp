package com.foodstore.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foodstore.dao.Food_Dao;
import com.foodstore.pojo.Food_pojo;
import com.foodstore.utility.DBConnection;

public class FoodDaoJDBCimpl implements Food_Dao{

	
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sqlQuery = null;
		Scanner input = new Scanner(System.in);

		
		public boolean add(Food_pojo food) throws Exception 
		{
			con = DBConnection.getDBConn();
			
			sqlQuery = "insert into food(food_Name,food_Price) values (?,?)";
			
			pstmt = con.prepareStatement(sqlQuery);
			
			pstmt.setString(1,food.getFood_Name());
			pstmt.setDouble(2, food.getFood_Price());
			
			int i = pstmt.executeUpdate();
			
			
			DBConnection.closeCon();
			if(i>0) {
				return true;
			}
			
			return false;
		}


		public boolean update(Food_pojo food) throws Exception{
			
			con = DBConnection.getDBConn();
			sqlQuery = "update food set food_Name=?,food_Price=? where food_Id=?;";
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1,food.getFood_Name());
			pstmt.setDouble(2,food.getFood_Price());
			pstmt.setInt(3,food.getFood_Id());
			int i = pstmt.executeUpdate();
			if(i>0) {
				return true;
			}
			DBConnection.closeCon();
			return false;
		}



		public List<Food_pojo> all() throws Exception {
			
			con = DBConnection.getDBConn();
			
			List<Food_pojo> foodList = new ArrayList<Food_pojo>();
			sqlQuery = "select *From foodapp.food";
			pstmt = con.prepareStatement(sqlQuery);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Food_pojo food = new Food_pojo(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				foodList.add(food);
			}
			DBConnection.closeCon();
			return foodList;
		}



		public boolean delete(int food_Id) throws Exception {
			
			con = DBConnection.getDBConn();
			sqlQuery = " delete from food where food_Id=?";
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setInt(1, food_Id);
			int i = pstmt.executeUpdate();
			
			
			if(i>0) {
				return true;
			}
			DBConnection.closeCon();
			return false;
		}



		public Food_pojo get(int food_Id) throws Exception {
			
			con = DBConnection.getDBConn();
			sqlQuery = " select * From food Where food_Id=?";
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setInt(1, food_Id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Food_pojo food = new Food_pojo(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				return food;
			}
			DBConnection.closeCon();
			return null;
		}



		public List<Food_pojo> get(String food_Name) throws Exception {
			
			con = DBConnection.getDBConn();
			sqlQuery = "select * From food Where food_Name like ?";
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1, food_Name+"%");
			
			rs = pstmt.executeQuery();
			List<Food_pojo> foodList = new ArrayList<Food_pojo>();
			
			while(rs.next()) {
				Food_pojo food = new Food_pojo(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				foodList.add(food);
			} 
			
			DBConnection.closeCon();
			return foodList;
		}



		public List<Food_pojo> sortByPrice(boolean flag) throws Exception {
			
			con = DBConnection.getDBConn();
			sqlQuery = " select* from food order by food_Price  asc";
			pstmt = con.prepareStatement(sqlQuery);
			List<Food_pojo> foodList = new ArrayList<Food_pojo>();
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Food_pojo food = new Food_pojo(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				foodList.add(food);
			}
			DBConnection.closeCon();
			return foodList;
		}



		public List<Food_pojo> sortByName(boolean flag) throws Exception {
			con = DBConnection.getDBConn();
			if(flag== true) {
				sqlQuery = "select* from food order by food_Name  asc";
			}
			else {
				sqlQuery = "select* from food order by food_Name  desc";
			}
			pstmt = con.prepareStatement(sqlQuery);
			List<Food_pojo> foodList = new ArrayList<Food_pojo>();
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Food_pojo food = new Food_pojo(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				foodList.add(food);
			}
			DBConnection.closeCon();
			
			return foodList;
		}

		
}
