<%@ page language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.UserInfo.User" %>
<html>
<body>
<h2>Registration Successful!</h2>
<p>Registration ID: <%= request.getAttribute("regId") %></p>
<p>Welcome, <%= ((User)request.getAttribute("user")).getFirstName() %>!</p>
</body>
</html>


 