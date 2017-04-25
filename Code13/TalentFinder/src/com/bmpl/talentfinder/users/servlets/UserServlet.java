package com.bmpl.talentfinder.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bmpl.talentfinder.users.dao.UserDAO;
import com.bmpl.talentfinder.users.dto.UserDTO;
import com.bmpl.talentfinder.users.dto.UserRoleRightMappingDTO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private int counter;
	@Override
	public void init(){
		counter = 1;
		System.out.println("Init Call Once....."+counter);
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String userid  = request.getParameter("userid");
		String password = request.getParameter("pwd");
		String pinCodeData = request.getParameter("pincode");
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(userid);
		userDTO.setPassword(password);
		userDTO.setPinCode(pinCodeData);
		UserDAO userDAO = new UserDAO();
		
		int pinCode = 10001;
		//int pins[] = {1001,1002,1003}; 
		//if(userid.equals(password)){
		try{
		UserRoleRightMappingDTO userRoleDTO = userDAO.isAuthenticate(userDTO);	
		if(userRoleDTO!=null){
			HttpSession session = request.getSession(true); // Create a New Session
			//session.setAttribute("userid", userid);
			//session.setAttribute("pin", pinCode);
			session.setAttribute("userinfo", userRoleDTO);
			//request.setAttribute("pin", pinCode);
			response.setHeader("Cache-control", "no-cache, no-store");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");
			response.sendRedirect("welcome");
			//response.sendRedirect("welcome.html");
			//response.sendRedirect("http://www.google.com");
			//response.sendRedirect("welcome?uid="+userid+"&pin="+pinCode); // Query String
			//RequestDispatcher rd = request.getRequestDispatcher("welcome");
			//rd.forward(request, response);
		}
		else{
			PrintWriter out = response.getWriter();
			out.println("Invalid Userid or Password");
			//out.println("Hello Client "+counter);
			out.close();
		}
		}catch(SQLException e){
			response.sendRedirect("customerror.html");
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			response.sendRedirect("customerror.html");
			e.printStackTrace();
		}
		catch(Exception e){
			
			response.sendRedirect("customerror.html");
			e.printStackTrace();
		}
		//System.out.println("GET (Service ) CALL AGAIN AND AGAIN....");
		
		
		//counter++;
		
		
	}

}
