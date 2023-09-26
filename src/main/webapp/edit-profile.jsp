<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Profile - Pizza Order System</title>
</head>
<body>
<h1>Edit Profile</h1>

<%-- Display error message if any --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<form action="edit-profile" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${user.username}" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${user.email}" required><br><br>

    <!-- Add more user profile fields as needed -->

    <input type="submit" value="Save Changes">
</form>

<p><a href="user-profile.jsp">Back to User Profile</a></p>
</body>
</html>