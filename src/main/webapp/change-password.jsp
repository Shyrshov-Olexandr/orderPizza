<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password - Pizza Order System</title>
</head>
<body>
<h1>Change Password</h1>

<%-- Display error message if any --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<form action="change-password" method="post">
    <label for="currentPassword">Current Password:</label>
    <input type="password" id="currentPassword" name="currentPassword" required><br><br>

    <label for="newPassword">New Password:</label>
    <input type="password" id="newPassword" name="newPassword" required><br><br>

    <label for="confirmNewPassword">Confirm New Password:</label>
    <input type="password" id="confirmNewPassword" name="confirmNewPassword" required><br><br>

    <input type="submit" value="Change Password">
</form>

<p><a href="user-profile.jsp">Back to User Profile</a></p>
</body>
</html>