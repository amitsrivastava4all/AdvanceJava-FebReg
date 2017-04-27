package com.bmpl.talentfinder.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		String userid  = request.getParameter("userid");  // Input Data (HTML)
		String password = request.getParameter("pwd");
		String pinCodeData = request.getParameter("pincode");
		String favcolor = request.getParameter("favcolor");
		
		int price = 1000;
		int quantity = 2;
		int bill = price* quantity;
		request.setAttribute("bill", bill);
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
			
			// Check Cookie Exist or Not
			boolean isCookieFound = false;
			Cookie cookies [] = request.getCookies();
			if(cookies!=null && cookies.length>0){
				for(Cookie c: cookies){
					if(c.getName().equals("mycolor")){
						isCookieFound = true;
						break;
					}
				}
			}
			// Define Cookie
			if(!isCookieFound){
				//int t = 10*20;
			Cookie cookie = new Cookie("mycolor",favcolor);
			cookie.setMaxAge(365*24*60*60);
			response.addCookie(cookie);
			}
			
			//session.setAttribute("userid", userid);
			//session.setAttribute("pin", pinCode);
			session.setAttribute("userinfo", userRoleDTO);
			//request.setAttribute("pin", pinCode);
			response.setHeader("Cache-control", "no-cache, no-store");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.talent");
			rd.forward(request, response);
			//String enCodedURL = response.encodeRedirectURL("welcome.talent");
			//response.sendRedirect(enCodedURL);
			//response.sendRedirect("welcome.talent");
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
			e.printStackTrace();
			response.sendRedirect("customerror.html");
			
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			response.sendRedirect("customerror.html");
			
		}
		catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("customerror.html");
			
		}
		//System.out.println("GET (Service ) CALL AGAIN AND AGAIN....");
		
		
		//counter++;
		
		
	}

}
