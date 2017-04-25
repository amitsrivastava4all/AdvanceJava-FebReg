package com.bmpl.talentfinder.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bmpl.talentfinder.users.dto.RightDTO;
import com.bmpl.talentfinder.users.dto.UserRoleRightMappingDTO;

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
		UserRoleRightMappingDTO userRoleDTO = (UserRoleRightMappingDTO) session.getAttribute("userinfo");
		//String userid = (String)session.getAttribute("userid");
		//int pinCode = (Integer)session.getAttribute("pin");
		//String userid = request.getParameter("userid");
		//String userid = request.getParameter("uid");
		//int pinCode = Integer.parseInt(request.getParameter("pin"));
		//int pinCode = (Integer)request.getAttribute("pin");
		
		//out.println("<html><body>");
		//out.println("Score is "+score);
		//score= score + 10;
		//response.setHeader("refresh", "2");
		
		
		String logout = "<form action='logout'><button type='submit'>Logout</button></form>";
		String welcomeMessage = "<br><h2>Welcome "
		+userRoleDTO.getUserid()+" Role "+userRoleDTO.getRole()+"</h2>"; 
		String welcome = logout+welcomeMessage;
		String ul = "<ul class='nav navbar-nav navbar-right'>";
		String li = "";
		for(RightDTO rightDTO : userRoleDTO.getRightList()){
			 li +=  "<li><a href='"+rightDTO.getScreen()+"'>"
		+rightDTO.getName()+"</a></li>";
		}
		ul = ul + li +"</ul>";
		String html = "<!DOCTYPE html><html lang='en'>  <head>    <meta charset='utf-8'>    <meta http-equiv='X-UA-Compatible' content='IE=edge'>    <meta name='viewport' content='width=device-width, initial-scale=1'>        <meta name='description' content=''>    <meta name='author' content=''>    <link rel='icon' href='../../favicon.ico'>    <title>Dashboard </title>        <link href='css/bootstrap.min.css' rel='stylesheet'>  </head>  <body>    <nav class='navbar navbar-inverse navbar-fixed-top'>      <div class='container-fluid'>        <div class='navbar-header'>          <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#navbar' aria-expanded='false' aria-controls='navbar'>            <span class='sr-only'>Toggle navigation</span>            <span class='icon-bar'></span>            <span class='icon-bar'></span>            <span class='icon-bar'></span>          </button>          <a class='navbar-brand' href='#'>Project name</a>        </div>        <div id='navbar' class='navbar-collapse collapse'>        "
				+welcome+"<br>"+ul+"          <form class='navbar-form navbar-right'>            <input type='text' class='form-control' placeholder='Search...'>          </form>        </div>      </div>    </nav>    <div class='container-fluid'>      <div class='row'>        <div class='col-sm-3 col-md-2 sidebar'>          <ul class='nav nav-sidebar'>            <li class='active'><a href='#'>Overview <span class='sr-only'>(current)</span></a></li>            <li><a href='#'>Reports</a></li>                      </ul>                  </div>        <div class='col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main'>          <h1 class='page-header'>Dashboard</h1>          <div class='row placeholders'>            <div class='col-xs-6 col-sm-3 placeholder'>              <img src='data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==' width='200' height='200' class='img-responsive' alt='Generic placeholder thumbnail'>              <h4>Label</h4>              <span class='text-muted'>Something else</span>            </div>            <div class='col-xs-6 col-sm-3 placeholder'>              <img src='data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==' width='200' height='200' class='img-responsive' alt='Generic placeholder thumbnail'>              <h4>Label</h4>              <span class='text-muted'>Something else</span>            </div>            <div class='col-xs-6 col-sm-3 placeholder'>              <img src='data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==' width='200' height='200' class='img-responsive' alt='Generic placeholder thumbnail'>              <h4>Label</h4>              <span class='text-muted'>Something else</span>            </div>            <div class='col-xs-6 col-sm-3 placeholder'>              <img src='data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==' width='200' height='200' class='img-responsive' alt='Generic placeholder thumbnail'>              <h4>Label</h4>              <span class='text-muted'>Something else</span>            </div>          </div>          <h2 class='sub-header'>Section title</h2>                  </div>      </div>    </div>       <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>        <script src='../../dist/js/bootstrap.min.js'></script>      </body></html>";
		out.println(html);
		//		Enumeration<String> en =request.getHeaderNames();
//		while(en.hasMoreElements()){
//			String headerName = en.nextElement();
//			out.println("Header Name is "+headerName
//					+" Value "+request.getHeader(headerName)+"<br>");
//		}
		//out.println("<h1>Welcome "+userid+" Pincode "+pinCode+" </h1><br>"+logout+"</body></html>");
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");
		out.close();
		}
	}

}
