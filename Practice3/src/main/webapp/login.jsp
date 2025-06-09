<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Registration - MyFriends</title>
</head>
<body>
<h2>User Registration</h2>
<form action="RegistrationServlet" method="post">
<label>First Name:</label>
<input type="text" name="firstName"><br><br>
 
        <label>Last Name:</label>
<input type="text" name="lastName"><br><br>
 
        <label>Country:</label>
<select name="country">
<option value="">Select</option>
<option value="India">India</option>
<option value="USA">USA</option>
<option value="UK">UK</option>
</select><br><br>
 
        <label>Languages Known:</label><br>
<input type="checkbox" name="languages" value="English"> English<br>
<input type="checkbox" name="languages" value="Hindi"> Hindi<br>
<input type="checkbox" name="languages" value="French"> French<br><br>
 
        <label>Gender:</label>
<input type="radio" name="gender" value="Male"> Male
<input type="radio" name="gender" value="Female"> Female<br><br>
 
        <input type="submit" value="Submit">
<input type="reset" value="Reset">
</form>
</body>
</html>
 