package com.foodstore.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodstore.dao.Food_Dao;
import com.foodstore.dao.User_Dao;
import com.foodstore.dao.jdbcimpl.FoodDaoJDBCimpl;
import com.foodstore.dao.jdbcimpl.UserDaoJDBCimpl;
import com.foodstore.pojo.Food_pojo;
import com.foodstore.pojo.User_pojo;

@WebServlet("/do.foodoperation")
public class FoodController extends HttpServlet{


	int User_Id;
	String First_Name;
	String Last_Name;
	String Type;
	String User_Email;
	String User_Password;
	String User_Address;


	
	String foodname;
	double foodprice;
	String action;
	Food_pojo food = null;
	User_pojo user = null;
	User_Dao userDao = new UserDaoJDBCimpl();
	Food_Dao foodDao = new FoodDaoJDBCimpl();
	int foodId;
	boolean flag;
	HttpSession session;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		session = req.getSession();
//		*********************************Adding Food***************************************
		action = req.getParameter("action");
		if(action!=null && action.equalsIgnoreCase("addfood")){
			foodname = req.getParameter("foodname");
			foodprice = Double.parseDouble(req.getParameter("foodprice"));

			//create a food object with user data.
			food = new Food_pojo(foodname,foodprice);
			
			try {
				flag = foodDao.add(food);
				
				if(flag)
				{
					req.setAttribute("Smsg", "Food is Added");
				}
				else{
					req.setAttribute("Emsg", "Food is Not Added");
					
				}
				
				RequestDispatcher rd = req.getRequestDispatcher("AddFood.jsp");
				rd.forward(req, resp);
				
			} catch (Exception e) {
				pw.print(e);
			}

//			pw.print("<h2>Food Name:- "+foodname+"</h2>");
			 //			pw.print("<h2>Food Price:- "+foodprice+"</h2>");
//			
			pw.close();
					
		}
//		************************************************************************
		
//		***********************************Update Food*************************************
		action = req.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("updatefood")) {
			foodname = req.getParameter("food_name");
			foodprice = Double.parseDouble(req.getParameter("food_price"));
			foodId = Integer.parseInt(req.getParameter("food_id"));
			food = new Food_pojo(foodId,foodname,foodprice);
			
			try {
				flag = foodDao.update(food);
				
				if(flag) {
					List<Food_pojo>flist = foodDao.all();
					session.setAttribute("flist", flist);
					req.setAttribute("Smsg", foodname+" Food update Successfully");
				}else {
					req.setAttribute("Emsg", foodname+" Food is NOT Updated");
				}
				
				RequestDispatcher rd = req.getRequestDispatcher("foodList.jsp");
				rd.forward(req, resp);
				
			} catch (Exception e) {
			
				pw.print(e);
			}
			pw.close();
						
		}
		
//		************************************************************************

//		***********************************Add User*************************************
		action = req.getParameter("action");
		if(action!=null && action.equalsIgnoreCase("adduser")) {
			
			First_Name = req.getParameter("user_Name_First");
			Last_Name = req.getParameter("user_Name_Last");
			Type = req.getParameter("user_Type");
			User_Email = req.getParameter("user_Email");
			User_Password = req.getParameter("user_Password");
			User_Address = req.getParameter("user_Address");
			
//			System.out.println(user_Type);
			user = new User_pojo(First_Name,Last_Name,Type,User_Email,User_Password,User_Address);
			
			try {
				flag = userDao.add(user);
//				System.out.println(flag);
				if(flag) {
					req.setAttribute("Smsg", "User is Successfully Added");
				}else {
					req.setAttribute("Emsg", "User is NOT ADDED");	
				}
				RequestDispatcher rd = req.getRequestDispatcher("Adduser.jsp");
				rd.forward(req, resp);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			pw.close();
			
		}
		
//		***********************************Update User*************************************
		action = req.getParameter("action");
		if(action!=null && action.equalsIgnoreCase("updateuser")) {
			
			User_Id = Integer.parseInt(req.getParameter("User_Id"));
			First_Name = req.getParameter("First_Name");
			Last_Name = req.getParameter("Last_Name");
			Type = req.getParameter("Type");
			User_Email = req.getParameter("User_Email");
			User_Password = req.getParameter("User_Password");
			User_Address = req.getParameter("User_Address");
			System.out.println(User_Id);
			System.out.println(First_Name);
			System.out.println(Last_Name);
			System.out.println(Type);
			System.out.println(User_Email);
			System.out.println(User_Password);
			System.out.println(User_Address);
			user = new User_pojo(User_Id,First_Name,Last_Name,Type,User_Email,User_Password,User_Address);
			try {
				flag = userDao.update(user);
				System.out.println(flag);
				if(flag) {
					List<User_pojo> ulist = userDao.all();
					session.setAttribute("ulist", ulist);
					req.setAttribute("Smsg", First_Name+" User Updated SUCCESSFULLY");
					
				}else {
					req.setAttribute("Emsg","User NOT Updated");
				}
				RequestDispatcher rd = req.getRequestDispatcher("userList.jsp");
				rd.forward(req, resp);

			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
			pw.close();
			
		}
//		*******************************************USER LOGIN*******************************************
		action = req.getParameter("action");
		if(action != null && action.equalsIgnoreCase("userlogin")) {
			
			User_Email = req.getParameter("User_Email");
			User_Password = req.getParameter("User_Password");
			try {
				user = userDao.userLogin(User_Email,User_Password);
				if(user !=null) {
					session = req.getSession();
					session.setAttribute("user",user);
					req.setAttribute("Smsg",user.getFirst_Name()+" Welcome to THE APP");
					req.getRequestDispatcher("index.jsp").forward(req, resp);
//					rd.forward(req, resp);
					
				}else{
					req.setAttribute("Emsg", "User NOT RECOGNIZED");
//					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
//					rd.forward(req, resp);
				}
			} catch (Exception e) {
	
				e.printStackTrace();
			}
						
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		action = req.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("showfoodlist")){
			try {
				List<Food_pojo> flist = foodDao.all();
				session.setAttribute("flist", flist);
				//sendRedirect method of HttpServletResponse is used the new request to next resource.
				resp.sendRedirect("foodList1.jsp");
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		else if(action!=null && action.equalsIgnoreCase("deletefood")) {
			foodId = Integer.parseInt(req.getParameter("food_Id"));
			foodname = req.getParameter("food_Name");
			try {
				flag = foodDao.delete(foodId);
				
				if(flag) {
					
					req.setAttribute("Smsg",foodname+" Food is Deleted");
					List<Food_pojo> flist = foodDao.all();
					session.setAttribute("flist", flist);
		
					
				}else {
					req.setAttribute("Esmg",foodname+" Food is not deleted");
				}
				RequestDispatcher rd = req.getRequestDispatcher("foodList1.jsp");
				rd.forward(req, resp);
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		else if(action!=null && action.equalsIgnoreCase("showuserlist")) {
			
			try {
				List<User_pojo> ulist = userDao.all();
				session.setAttribute("ulist", ulist);
				ulist.forEach(System.out::println);
				resp.sendRedirect("userList.jsp");
			} catch (Exception e) {

				e.printStackTrace();
			}
	
			

			
		}
		else if(action!=null && action.equalsIgnoreCase("deleteuser")) {
			
			User_Id =  Integer.parseInt(req.getParameter("User_Id"));
			First_Name = req.getParameter("First_Name");
			
			try {
	
				flag = userDao.delete(User_Id);
				
				if(flag) {
					
					req.setAttribute("Smsg", First_Name+" is DELETED");
					List<User_pojo> ulist = userDao.all();
					session.setAttribute("ulist", ulist);

				}else {
					
					req.setAttribute("Emsg", "USER NOT DELETED");
				}
				RequestDispatcher rd = req.getRequestDispatcher("userList.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
	
				e.printStackTrace();
			}
		
		}
		else if(action!=null && action.equalsIgnoreCase("userlogout")) {
			session = req.getSession();
			if(session !=null) {
				session.invalidate();
				resp.sendRedirect("index.jsp");
			}
			
		}
	}
	
}
