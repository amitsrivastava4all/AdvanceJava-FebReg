package com.bmpl.talentfinder.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session ==null){
			response.sendRedirect("index.html");
		}
		else{
			//session.setMaxInactiveInterval(60);
		PrintWriter out = response.getWriter();
		String userid = (String)session.getAttribute("userid");
		int pinCode = (Integer)session.getAttribute("pin");
		//String userid = request.getParameter("userid");
		//String userid = request.getParameter("uid");
		//int pinCode = Integer.parseInt(request.getParameter("pin"));
		//int pinCode = (Integer)request.getAttribute("pin");
		out.println("<html><body><h1>Welcome "+userid+" Pincode "+pinCode+" </h1></body></html>");
		out.close();
		}
	}

}
