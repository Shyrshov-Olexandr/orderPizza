<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pizza Selection - Pizza Order System</title>
</head>
<body>
<!-- Your JSTL code here -->
<h1>Select Your Pizza Type</h1>

<%-- Display error message if any --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<form action="add-ingredients" method="post">
    <label for="pizzaType">Choose Pizza Type:</label>
    <select id="pizzaType" name="pizzaType" required>
        <option value="">Select</option>
        <c:forEach items="${pizzaTypes}" var="pizzaType">
            <option value="${pizzaType.id}">${pizzaType.name} - $${pizzaType.price}</option>
        </c:forEach>
    </select><br><br>

    <input type="submit" value="Next">
</form>
</body>
</html>