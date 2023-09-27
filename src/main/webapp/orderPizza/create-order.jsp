<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Order - Pizza Order System</title>
</head>
<body>
<h1>Review Your Pizza Order</h1>

<%-- Display error message if any --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<h2>Selected Pizza Type:</h2>
<p>${selectedPizza.name} - $${selectedPizza.price}</p>

<h2>Selected Ingredients:</h2>
<ul>
    <c:forEach items="${selectedIngredients}" var="ingredient">
        <li>${ingredient.name} - $${ingredient.price}</li>
    </c:forEach>
</ul>

<h2>Total Price:</h2>
<p>$${totalPrice}</p>

<form action="confirm-order" method="post">
    <input type="hidden" name="pizzaTypeId" value="${selectedPizza.id}">
    <input type="hidden" name="selectedIngredients" value="${selectedIngredientsIds}">

    <input type="submit" value="Confirm Order">
</form>

<p><a href="pizza-selection.jsp">Back to Pizza Selection</a></p>
</body>
</html>