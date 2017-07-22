<%@page import="com.srivastava.mvc.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC Demo</title>
</head>
<body>
<h1>Product Search</h1>
<form action="Controller">
<label>Price</label><input type="text" name="price" placeholder="Type Price Here"/>
<button type="submit">Search</button>
</form>
<%
ArrayList<ProductDTO> productList =  (ArrayList<ProductDTO>) request.getAttribute("prodlist");
if(productList!=null){
if(productList.size()>0){
%>
<fieldset>
<legend>Search Result</legend>
<table border="1">
<tr><th>Id</th><th>Name</th><th>Desc</th><th>Price</th><th>Image</th></tr>
<%
for(ProductDTO product : productList){
%>
<tr>
<td><%=product.getId() %></td>
<td><%=product.getName() %></td>
<td><%=product.getDescr() %></td>
<td><%=product.getPrice() %></td>
<td><img src="<%=product.getImage() %>" width=100 height=100></td>
</tr>
<%
}
%>
</table>
</fieldset>
<%
}
else{
%>
<h1>No Record Found....</h1>
<%	
}

}
%>
</body>
</html>