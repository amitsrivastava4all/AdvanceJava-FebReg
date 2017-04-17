package com.bmpl.talentfinder.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		int pinCode = 10001;
		//int pins[] = {1001,1002,1003}; 
		if(userid.equals(password)){
			HttpSession session = request.getSession(true); // Create a New Session
			session.setAttribute("userid", userid);
			session.setAttribute("pin", pinCode);
			//request.setAttribute("pin", pinCode);
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
		//System.out.println("GET (Service ) CALL AGAIN AND AGAIN....");
		
		
		//counter++;
		
		
	}

}
