package com.srivastava.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srivastava.mvc.dao.DAO;
import com.srivastava.mvc.dto.ProductDTO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double price = Double.parseDouble(request.getParameter("price"));
		DAO dao= new DAO();
		try {
			
			ArrayList<ProductDTO> productList = dao.getProductByPrice(price);
			request.setAttribute("prodlist", productList);
			RequestDispatcher rd = request.getRequestDispatcher("indexel.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
