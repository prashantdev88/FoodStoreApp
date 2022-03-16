package com.foodstore.pojo;

public class User_pojo {

	private int User_Id;
	private String First_Name;
	private String Last_Name;
	private String Type;
	private String User_Email;
	private String User_Password;
	private String User_Address;

	
	public User_pojo(int User_Id,String First_Name,String Last_Name,String Type) {
	
		this.User_Id = User_Id;
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.Type = Type;
	}
	
	public User_pojo(int User_Id,String First_Name,String Last_Name,String Type,String User_Email,String User_Password,String User_Address){
		
		this.User_Id = User_Id;
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.Type = Type;
		this.User_Email = User_Email;
		this.User_Password = User_Password;
		this.User_Address = User_Address;
		
	}
	
	public User_pojo(String First_Name,String Last_Name,String Type,String User_Email,String User_Password,String User_Address){
		
		
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.Type = Type;
		this.User_Email = User_Email;
		this.User_Password = User_Password;
		this.User_Address = User_Address;
		
	}
	
	
	
	

	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int User_Id) {
		this.User_Id = User_Id;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String First_Name) {
		this.First_Name = First_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String Last_Name) {
		this.Last_Name = Last_Name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	public String getUser_Email() {
		return User_Email;
	}
	public void setUser_Email(String User_Email) {
		this.User_Email = User_Email;
	}
	public String getUser_Password() {
		return User_Password;
	}
	public void setUser_Password(String User_Password) {
		this.User_Password = User_Password;
	}
	public String getUser_Address() {
		return User_Address;
	}
	public void setUser_Address(String User_Address) {
		this.User_Address = User_Address;
	}
	
	@Override
	public String toString() {
		return "User_pojo [User_Id=" + User_Id + ", First_Name=" + First_Name + ", Last_Name="
				+ Last_Name + ", Type=" + Type + ", User_Email=" + User_Email + ", User_Password="
				+ User_Password + ", User_Address=" + User_Address + "]";
	}
	
}
