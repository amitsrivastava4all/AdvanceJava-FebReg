package com.bmpl.talentfinder.users.dao;

import java.util.ResourceBundle;

public interface DBPropertyReader {
	public static ResourceBundle rb = ResourceBundle.getBundle("dbconfig");
	
	public static String getValue(String key){
		return rb.getString(key);
	}

}
