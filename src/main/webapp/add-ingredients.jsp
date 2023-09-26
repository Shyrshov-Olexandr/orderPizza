<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Ingredients - Pizza Order System</title>
</head>
<body>
<h1>Add Ingredients to Your Pizza</h1>

<%-- Display error message if any --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<form action="create-order" method="post">
    <input type="hidden" name="pizzaTypeId" value="${pizzaTypeId}">

    <h2>Available Ingredients:</h2>
    <c:forEach items="${availableIngredients}" var="ingredient">
        <input type="checkbox" name="selectedIngredients" value="${ingredient.id}">
        <label>${ingredient.name} - $${ingredient.price}</label><br>
    </c:forEach><br>

    <input type="submit" value="Create Order">
</form>

<p><a href="pizza-selection.jsp">Back to Pizza Selection</a></p>
</body>
</html>