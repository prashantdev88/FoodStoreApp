package com.foodstore.dao;

import java.util.List;

import com.foodstore.pojo.Food_pojo;

public interface Food_Dao {


	boolean add(Food_pojo food) throws Exception;

	boolean update(Food_pojo food) throws Exception;

	List<Food_pojo> all() throws Exception;

	boolean delete(int food_Id) throws Exception;

	Food_pojo get(int food_Id) throws Exception;

	List<Food_pojo> get(String food_Name) throws Exception;

	List<Food_pojo> sortByPrice(boolean flag) throws Exception;

	List<Food_pojo> sortByName(boolean flag) throws Exception;
}
