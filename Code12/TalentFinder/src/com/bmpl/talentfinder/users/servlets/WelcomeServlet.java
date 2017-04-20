package com.bmpl.talentfinder.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
	int score;
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
		
		out.println("<html><body>");
		out.println("Score is "+score);
		score= score + 10;
		//response.setHeader("refresh", "2");
		String logout = "<form action='logout'><button type='submit'>Logout</button></form>";
		Enumeration<String> en =request.getHeaderNames();
		while(en.hasMoreElements()){
			String headerName = en.nextElement();
			out.println("Header Name is "+headerName
					+" Value "+request.getHeader(headerName)+"<br>");
		}
		out.println("<h1>Welcome "+userid+" Pincode "+pinCode+" </h1><br>"+logout+"</body></html>");
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");
		out.close();
		}
	}

}
