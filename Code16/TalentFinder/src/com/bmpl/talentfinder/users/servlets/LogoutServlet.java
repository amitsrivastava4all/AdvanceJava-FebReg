package com.bmpl.talentfinder.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.talent")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
//		if(session==null){
//			response.sendRedirect("index.html");
//		}
//		else
//		{
		String colorValue = "cyan";
		Cookie cookies [] = request.getCookies();
		if(cookies!=null && cookies.length>0){
			for(Cookie c: cookies){
				if(c.getName().equals("mycolor")){
					colorValue = c.getValue();
					break;
				}
			}
		}
		
			session.removeAttribute("userid");
			session.removeAttribute("pin");
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("header");
			request.setAttribute("mycolor", colorValue);
			rd.include(request, response);
			//out.println("<html><body bgcolor='"+colorValue+"'>");
			out.println("Logout SuccessFully...");
			RequestDispatcher rd2 = request.getRequestDispatcher("footer");
			rd2.include(request, response);
		//}
	}

}
