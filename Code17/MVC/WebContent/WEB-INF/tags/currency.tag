<%@tag import="java.text.NumberFormat"%>
<%@tag import="java.util.Locale"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="country" required="true" type="java.lang.String" %>
<%@attribute name="lang" required="true" type="java.lang.String" %>
<%@attribute name="pr" required="true" type="java.lang.Double" %>
<%
Locale locale = new Locale(lang,country);
NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
String formattedCurrency = nf.format(pr);
%>
<%=formattedCurrency %>
