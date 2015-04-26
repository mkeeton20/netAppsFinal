<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String fName = request.getParameter("fnameA");
	String lName = request.getParameter("lnameA");
	String uName = request.getParameter("unameA");
	String email = request.getParameter("emailA");
	String password = request.getParameter("pwdA"); 
	String list =  request.getParameterNames().toString();
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><%=fName %>
<%=lName %>
<%=uName %>
<%=email %>
<%=password %>
<%=list %>
</h1>
</body>
</html>