package com.bmpl.talentfinder.users.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//POJO
// DAO - DB Code
public class UserDAO {

	private Connection createConnection() throws ClassNotFoundException, SQLException{
		// Step - 1 Load the Driver
		// oracle.jdbc.driver.OracleDriver
		String driverName = "com.mysql.jdbc.Driver";
		Class.forName(driverName);
		// Step -2 Create Connection
		// jdbc:oracle:thin:@localhost:1521:servicename
		String dbURL = "jdbc:mysql://localhost:3306/talentfinderdb";
		String userid ="root";
		String password = "";
		Connection connection = DriverManager.getConnection(dbURL,userid,password);
//		if(connection!=null){
//			System.out.println("Connection Created...");
//			//connection.close();
//		}
		return connection;
		
		
		
		
	}
	
	public boolean addUser(String userid, String password) throws ClassNotFoundException, SQLException{
		
		Connection connection = null;
		Statement stmt = null;
		try{
		String sql = "insert into user_master (userid,password) "
				+ "values('"+userid+"','"+password+"')";
		connection = createConnection();
		// Step -3 Create Do Query
		stmt = connection.createStatement();
		int inserted = stmt.executeUpdate(sql);
		return inserted>0?true:false;
		}
		finally{
			if(stmt!=null){
			stmt.close();
			}
			if(connection!=null){
			connection.close();
			}
		}
		
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDAO userDAO = new UserDAO();
		if(userDAO.addUser("amit", "123")){
			System.out.println("Record Adderd...");
		}
		else
		{
			System.out.println("Record Not Added...");
		}
		//userDAO.createConnection();
	}
}
