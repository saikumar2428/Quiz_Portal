<%@ page language="java" %>
<html>
<body>
<h2>Registration Failed!</h2>
<p><%= request.getAttribute("error") %></p>
<a href="login.jsp">Try Again</a>
</body>
</html>
 