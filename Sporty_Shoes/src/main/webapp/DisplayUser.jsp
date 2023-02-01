<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.example.demo.*" %>
    <%@page import="java.util.*" %>
    <%@page import="java.nio.file.Files" %>
    <%@page import="java.io.File" %>
    <%@page import="java.util.Base64.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:20px;color:green;background-color:honeydew">

<h1 style="font-size:50px;color:red"><center>Sporty Shoes</center></h1>
<h3>Admin views Registered Users</h3>
<hr>
<table border="3px">
<tr><th>UserName</th><th>Password</th><th>Actions</th></tr>
<%List<UserPojo> list=(List<UserPojo>)request.getAttribute("u2"); %>

<%for(UserPojo s:list){ %>
<tr>
<td><%=s.getUsername() %></td>
<td><%=s.getPassword() %></td>

<td><a href="delete.jsp?username=<%=s.getUsername()%>">Delete</a></td>
<%} %>
</table>

</body>
</html>