package com.bmpl.talentfinder.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(userid.equals(password)){
			response.sendRedirect("welcome.html");
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
