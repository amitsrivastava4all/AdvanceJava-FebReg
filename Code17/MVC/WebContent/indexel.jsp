<%@page import="com.srivastava.mvc.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="tcs" tagdir="/WEB-INF/tags" %>  
<!DOCTYPE html >
<html>
<head>
<tcs:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC Demo</title>
</head>
<body class="container">
<tcs:myloop end="5" start="1">Hello How are You</tcs:myloop>
<tcs:date/>
<tcs:navbar companyname="TCS"/>
<h1>Product Search</h1>
<form action="Controller">
<label>Price</label><input type="text" name="price" placeholder="Type Price Here"/>
<button type="submit">Search</button>
</form>
<%-- Coming from Request Scope ${requestScope.prodlist }
Size is ${prodlist.size()}
Coming From Session Scope ${sessionScope.prodlist} --%>
<fieldset>
<legend>Search Result</legend>
<c:if test="${prodlist.size() > 0}">
<table border="1">
<tr><th>S.no</th><th>Id</th><th>Name</th><th>Desc</th><th>Price</th><th>Image</th></tr>
<c:forEach items="${prodlist}" var="product" varStatus="st">
<c:if test="${st.count mod 2 eq 0}">
<tr style="background-color: yellow">
</c:if>
<c:if test="${st.count mod 2 ne 0}">
<tr style="background-color: cyan">
</c:if>
<td>${st.count}</td>
<td>${product.id}</td>
<td>${product.name}</td>
<td>${product.descr }</td>
<td><tcs:currency lang="hi" country="IN" pr="${product.price}"/> </td>
<td><img src="${product.image}" width="100" height="100"></td>
</tr>
</c:forEach>
</table>
</c:if>
</fieldset>
</body>
</html>