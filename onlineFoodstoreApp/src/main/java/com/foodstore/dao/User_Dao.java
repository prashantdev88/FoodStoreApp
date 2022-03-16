package com.foodstore.dao;

import com.foodstore.pojo.User_pojo;
import java.util.List;

public interface User_Dao {

	boolean add (User_pojo user) throws Exception;
	
	boolean update (User_pojo user) throws Exception;
	
	boolean delete (int User_Id) throws Exception;
	
	List<User_pojo> all() throws Exception;
	
	User_pojo getById(int User_Id) throws Exception;
	
	List<User_pojo> getByFirstName(String First_Name) throws Exception;
	
	List<User_pojo> sortByFirstName(boolean flag) throws Exception;
	
	List<User_pojo> sortByLastName(boolean flag) throws Exception;
	
	User_pojo userLogin(String User_Email, String User_Password) throws Exception;
}
