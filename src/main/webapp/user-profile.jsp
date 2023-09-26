<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile - Pizza Order System</title>
</head>
<body>
<h1>User Profile</h1>

<%-- Display error message if any --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<h2>Welcome, ${user.username}!</h2>

<h2>User Information:</h2>
<p>Username: ${user.username}</p>
<p>Email: ${user.email}</p>
<!-- Add more user information as needed -->

<p><a href="edit-profile.jsp">Edit Profile</a></p>
<p><a href="change-password.jsp">Change Password</a></p>
<p><a href="logout.jsp">Logout</a></p>
</body>
</html>