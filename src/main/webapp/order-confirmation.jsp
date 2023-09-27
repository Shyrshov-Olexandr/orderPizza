<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation - Pizza Order System</title>
</head>
<body>
<h1>Order Confirmation</h1>

<%-- Display error message if any --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<h2>Order Details:</h2>
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

<h2>Order Status:</h2>
<p>${orderStatus}</p>

<p><a href="order-status.jsp">Back to Order Status</a></p>
</body>
</html>