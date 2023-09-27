<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard - Pizza Order System</title>
</head>
<body>
<h1>Admin Dashboard</h1>

<%-- Display error message if any --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<h2>Welcome, Administrator!</h2>

<h2>Manage Pizza Types:</h2>
<p><a href="add-pizza.jsp">Add New Pizza Type</a></p>
<p><a href="edit-pizza-types.jsp">Edit Pizza Types</a></p>

<h2>Manage Ingredients:</h2>
<p><a href="add-ingredient.jsp">Add New Ingredient</a></p>
<p><a href="edit-ingredients.jsp">Edit Ingredients</a></p>

<h2>View Orders:</h2>
<p><a href="view-orders.jsp">View All Orders</a></p>

<p><a href="logout">Logout</a></p>
</body>
</html>