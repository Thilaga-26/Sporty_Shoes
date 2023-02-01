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
<hr>

<%
UserPojo user=(UserPojo)request.getAttribute("u1");
%>
<h2><%="Hai "+user.getUsername()+" Welcome to Sporty Shoes" %></h2>

  <br>
  <br>
  
<%List<ShoePojo> list=(List<ShoePojo>)request.getAttribute("list"); %>

<%for(ShoePojo s:list){ %>

<%=s.getSname() %>
<%=s.getSbrand() %>
<%=s.getScost() %>
<%String path=s.getFile();
byte[] images=Files.readAllBytes(new File(path).toPath());
byte[] encodeBase64 = Base64.getEncoder().encode(images);
String base64Encoded = new String(encodeBase64, "UTF-8");
%>
<img alt="img" src="data:image/png;base64,<%=base64Encoded%>"/>

<h3><a href="Buy.jsp">Buy Now</a></h3>

<%} %>

</body>
</html>