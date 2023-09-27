<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Customize Your Pizza</title>
  <!-- Include CSS styles if needed -->
</head>
<body>
<h1>Customize Your Pizza</h1>

<form action="submit-customized-pizza" method="post">
  <%--@declare id="pizzasize"--%><%--@declare id="pizzatoppings"--%><label for="pizzaToppings">Choose Toppings:</label><br>
  <input type="checkbox" id="pepperoni" name="toppings" value="Pepperoni">
  <label for="pepperoni">Pepperoni</label><br>
  <input type="checkbox" id="mushrooms" name="toppings" value="Mushrooms">
  <label for="mushrooms">Mushrooms</label><br>
  <input type="checkbox" id="olives" name="toppings" value="Olives">
  <label for="olives">Olives</label><br>
  <!-- Add more topping options as needed -->

  <label for="crustType">Choose Crust Type:</label>
  <select id="crustType" name="crustType">
    <option value="Thin">Thin</option>
    <option value="Pan">Pan</option>
    <option value="Stuffed">Stuffed</option>
    <!-- Add more crust type options as needed -->
  </select><br>

  <label for="pizzaSize">Choose Pizza Size:</label>
  <input type="radio" id="small" name="pizzaSize" value="Small" required>
  <label for="small">Small</label>
  <input type="radio" id="medium" name="pizzaSize" value="Medium">
  <label for="medium">Medium</label>
  <input type="radio" id="large" name="pizzaSize" value="Large">
  <label for="large">Large</label><br>

  <label for="specialInstructions">Special Instructions (optional):</label><br>
  <textarea id="specialInstructions" name="specialInstructions" rows="4" cols="50"></textarea><br>

  <input type="submit" value="Place Order">
</form>
</body>
</html>