package com.srivastava.mvc.dao;

import java.util.ArrayList;

public class NavDAO {
	
	public static ArrayList<String> getMenus(){
		ArrayList<String> menus = new ArrayList<>();
		menus.add("Contact Us");
		menus.add("About Us");
		menus.add("Profile Us");
		menus.add("Home");
		return menus;
	}

}
