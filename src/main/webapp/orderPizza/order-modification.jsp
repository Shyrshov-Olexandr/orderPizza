<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Modification - Pizza Order System</title>
</head>
<body>
<h1>Modify or Cancel Your Order</h1>

<%-- Display error message if any --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<h2>Your Current Order:</h2>
<p>Order ID: ${order.id}</p>
<p>Selected Pizza Type: ${order.pizza.name} - $${order.pizza.price}</p>

<h2>Selected Ingredients:</h2>
<ul>
    <c:forEach items="${order.ingredients}" var="ingredient">
        <li>${ingredient.name} - $${ingredient.price}</li>
    </c:forEach>
</ul>

<h2>Total Price:</h2>
<p>$${order.totalPrice}</p>

<form action="modify-order" method="post">
    <input type="hidden" name="orderId" value="${order.id}">

    <h2>Modification Options:</h2>
    <label><input type="checkbox" name="addIngredients"> Add Ingredients</label><br>
    <label><input type="checkbox" name="removeIngredients"> Remove Ingredients</label><br>
    <label><input type="checkbox" name="cancelOrder"> Cancel Order</label><br>

    <input type="submit" value="Modify Order">
</form>

<p><a href="order-status.jsp">Back to Order Status</a></p>
</body>
</html>