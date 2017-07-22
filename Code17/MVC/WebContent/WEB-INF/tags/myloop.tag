<%@ tag language="java" pageEncoding="UTF-8"%>
<jsp:doBody var="x" scope="page"></jsp:doBody>
<%@attribute name="start" type="java.lang.Integer" required="true" %>
<%@attribute name="end" type="java.lang.Integer" required="true" %>
<%
for(int i = start; i<=end; i++){
%>
<h1 style="color:red">${x}</h1>
<%
}
%>