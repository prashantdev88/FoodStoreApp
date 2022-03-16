package com.foodstore.pojo;

public class Food_pojo {

	private int food_Id;
	private String food_Name;
	private double food_Price;
	
	public Food_pojo() {
		
	}
	
	public Food_pojo(int foodID,String foodName,double foodPrice) {
		this.food_Id = foodID;
		this.food_Name = foodName;
		this.food_Price = foodPrice;
	}

	public Food_pojo(String foodName,double foodPrice) {
		
		this.food_Name = foodName;
		this.food_Price = foodPrice;
	}

	
	public int getFood_Id() {
		return food_Id;
	}

	public void setFood_Id(int food_Id) {
		this.food_Id = food_Id;
	}

	public String getFood_Name() {
		return food_Name;
	}

	public void setFood_Name(String food_Name) {
		this.food_Name = food_Name;
	}

	public double getFood_Price() {
		return food_Price;
	}

	public void setFood_Price(double food_Price) {
		this.food_Price = food_Price;
	}

	@Override
	public String toString() {
		return "Food_pojo [food_Id=" + food_Id + ", food_Name=" + food_Name + ", food_Price=" + food_Price + "]";
	}
	
	
}
