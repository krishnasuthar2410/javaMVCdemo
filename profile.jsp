<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.krishna.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
User user = (User)session.getAttribute("user_session");
%>
<h2>Welcome...<%= user.getName() %></h2>

<a href="Logout">logout</a>

</body>
</html>