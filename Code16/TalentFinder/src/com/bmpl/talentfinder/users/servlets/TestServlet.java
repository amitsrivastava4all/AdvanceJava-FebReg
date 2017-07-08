package com.bmpl.talentfinder.users.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
//@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private int q;
	private ServletConfig sc;
	
	@Override
	public void init(ServletConfig sc) throws ServletException{
		super.init(sc);
		this.sc = sc;
		System.out.println("LOad on Start Up........");
		System.out.println("Servlet Config  "+sc.getInitParameter("email"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I Will Calll When First Request Comes..");
		//		ServletConfig sc = this.getServletConfig();
//		String email = sc.getInitParameter("email");
		String phoneNo = this.getServletConfig().getServletContext()
				.getInitParameter("tollfreeno");
		String email = this.getServletConfig().getInitParameter("email");
		String msg =(String)this.getServletConfig().getServletContext().getAttribute("message");
		
		response.getWriter().println("INit Param is "+email+" Toll Free No "+phoneNo+" Message is "+msg);
		//PrintWriter out = response.getWriter()
	}

}
