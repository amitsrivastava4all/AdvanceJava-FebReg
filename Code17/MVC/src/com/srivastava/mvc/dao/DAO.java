package com.srivastava.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.srivastava.mvc.dto.ProductDTO;

public class DAO {
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("config");
		Class.forName(rb.getString("drivername"));
		Connection con = DriverManager.getConnection(rb.getString("dburl"),"root","");
		return con;
	}
	
	
	public ArrayList<ProductDTO> getProductByPrice(double price) throws SQLException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> productList = new ArrayList<>();
		final String SQL = "select id, name, descr, price, image from product where price>=?";
		try{
			con = this.getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setDouble(1, price);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProductDTO prod = new ProductDTO(rs.getInt("id"), rs.getString("name"), rs.getString("descr"), rs.getString("image"), rs.getDouble("price"));
				productList.add(prod);
			}
		}
		finally{
			if(rs!=null){
				rs.close();
				
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return productList;
	}
	
	
	
}
