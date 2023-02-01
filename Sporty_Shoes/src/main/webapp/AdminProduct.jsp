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

<h1 style="font-size:50px;color:red"><center>Sporty Shoes</center>
<h3>Admin Views Shoes List</h3></h1>
<hr>
<table border="1px">
<%List<ShoePojo> list=(List<ShoePojo>)request.getAttribute("u2"); %>

<%for(ShoePojo s:list){ %>
<tr>
<td><%=s.getSname() %></td>
<td><%=s.getSbrand() %></td>
<td><%=s.getScost() %></td>
<%String path=s.getFile();
byte[] images=Files.readAllBytes(new File(path).toPath());
byte[] encodeBase64 = Base64.getEncoder().encode(images);
String base64Encoded = new String(encodeBase64, "UTF-8");
%>
<td><img alt="img" src="data:image/png;base64,<%=base64Encoded%>"/></td>

<%} %>
</table>
</body>
</html>