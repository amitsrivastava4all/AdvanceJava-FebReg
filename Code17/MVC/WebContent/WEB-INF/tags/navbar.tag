<%@tag import="java.util.ArrayList"%>
<%@tag import="com.srivastava.mvc.dao.NavDAO"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="companyname" type="java.lang.String" required="true" %>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><%=companyname %></a>
    </div>
	<% ArrayList<String> menus  = NavDAO.getMenus(); %>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      <% int counter = 0; %>
      <%for(String menu : menus) { %>
      <%if (counter == 0){ %>
        <li class="active"><a href="#"><%=menu %> <span class="sr-only">(current)</span></a></li>
        <%} else { %>
        <li><a href="#"><%=menu %></a></li>
        <%} 
      	counter++ ; 
        } %>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>