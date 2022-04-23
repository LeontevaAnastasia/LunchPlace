<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>--%>
<html>
<head>
    <title>Dish list</title>
</head>
<body>
<section>
    <h3><a href="index.jsp">Home</a></h3>
    <hr/>
    <h2>Dishes</h2>
    <a href="dishes?action=create">Add Dish</a>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Restaurant</th>
            <th>Description</th>
            <th>Price</th>
            <th>Date</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.dishes}" var="dish">
            <jsp:useBean id="dish" type="com.lanchplace.model.Dish"/>
                <td>${dish.restaurant}</td>
                <td>${dish.description}</td>
                <td>${dish.price}</td>
                <td>${dish.date}</td>
                <td><a href="dishes?action=update&id=${dish.id}">Update</a></td>
                <td><a href="dishes?action=delete&id=${dish.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>