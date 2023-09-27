<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Pizza Order Form</title>
</head>
<body>
<h1>Pizza Order Form</h1>

<form action="submit-order" method="post">
  <label for="pizzaType">Select Pizza Type:</label>
  <select id="pizzaType" name="pizzaType">
    <option value="1">Margherita</option>
    <option value="2">Pepperoni</option>
    <option value="3">Vegetarian</option>
  </select><br>

  <label for="quantity">Quantity:</label>
  <input type="number" id="quantity" name="quantity" min="1" required><br>

  <input type="submit" value="Place Order">
</form>
<!-- <c:forEach var="pizzaType" items="${pizzaTypes}">
            <option value="${pizzaType.id}">${pizzaType.name}</option>
       </c:forEach>
    -->
</body>
</html>
