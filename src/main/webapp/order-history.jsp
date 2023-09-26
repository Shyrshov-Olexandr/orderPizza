<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History - Pizza Order System</title>
</head>
<body>
<h1>Order History</h1>

<%-- Display error message if any --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<h2>Your Order History:</h2>

<table border="1">
    <tr>
        <th>Order ID</th>
        <th>Pizza Type</th>
        <th>Ingredients</th>
        <th>Total Price</th>
        <th>Order Status</th>
    </tr>
    <c:forEach items="${orderHistory}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.pizza.name}</td>
            <td>
                <ul>
                    <c:forEach items="${order.ingredients}" var="ingredient">
                        <li>${ingredient.name}</li>
                    </c:forEach>
                </ul>
            </td>
            <td>$${order.totalPrice}</td>
            <td>${order.orderStatus.status}</td>
        </tr>
    </c:forEach>
</table>

<p><a href="user-profile.jsp">Back to User Profile</a></p>
</body>
</html>