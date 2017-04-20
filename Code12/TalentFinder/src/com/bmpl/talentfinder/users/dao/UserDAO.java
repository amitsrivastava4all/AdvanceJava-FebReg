package com.bmpl.talentfinder.users.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bmpl.talentfinder.users.dto.UserDTO;
import static com.bmpl.talentfinder.users.dao.DBPropertyReader.getValue;
//POJO
// DAO - DB Code
public class UserDAO  {

	private Connection createConnection() throws ClassNotFoundException, SQLException{
		// Step - 1 Load the Driver
		// oracle.jdbc.driver.OracleDriver
		
		String driverName = getValue("drivername");
		Class.forName(driverName);
		// Step -2 Create Connection
		// jdbc:oracle:thin:@localhost:1521:servicename
		String dbURL = DBPropertyReader.getValue("dburl");
		String userid =DBPropertyReader.getValue("userid");
		String password = "";
		Connection connection = DriverManager.getConnection(dbURL
				,userid,password);
//		if(connection!=null){
//			System.out.println("Connection Created...");
//			//connection.close();
//		}
		return connection;
		
		
		
		
	}
	
	public boolean isAuthenticate(UserDTO userDTO) throws ClassNotFoundException, SQLException{
		boolean isFound = false;
		Connection connection = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			connection = createConnection();
			pstmt = connection.prepareStatement("select userid, password"
					+ " from user_master where"
					+ " userid=? and password=? and pincode=?");
			//stmt = connection.createStatement();
			pstmt.setString(1, userDTO.getUserid());
			pstmt.setString(2, userDTO.getPassword());
			pstmt.setInt(3, Integer.parseInt(userDTO.getPinCode()));
			rs = pstmt.executeQuery();
			//rs = stmt.executeQuery("select userid,password from "
				//	+ "user_master where userid ='"+userDTO.getUserid()
			//		+"' and password ='"+userDTO.getPassword()+"' and pincode="+userDTO.getPinCode());
			if(rs.next()){
				isFound = true;
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		
		return isFound;
		
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
