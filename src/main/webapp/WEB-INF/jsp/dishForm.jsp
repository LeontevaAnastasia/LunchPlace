<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Dish</title>
    <style>
        dl {
            background: none repeat scroll 0 0 #FAFAFA;
            margin: 8px 0;
            padding: 0;
        }

        dt {
            display: inline-block;
            width: 170px;
        }

        dd {
            display: inline-block;
            margin-left: 8px;
            vertical-align: top;
        }
    </style>
</head>
<body>
<section>
    <h3><a href="index.jsp">Home</a></h3>
    <hr>
    <h2>${param.action == 'create' ? 'Create dish' : 'Edit dish'}</h2>
    <jsp:useBean id="dish" type="com.lunchplace.model.Dish" scope="request"/>
    <form method="post" action="dishes">
        <input type="hidden" name="id" value="${dish.id}">
        <dl>
            <dt>Restaurant:</dt>
            <dd><input type="text" value="${dish.restaurant}" size=40 name="restaurant" required></dd>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="${dish.description}" size=40 name="description" required></dd>
        </dl>
        <dl>
            <dt>Price:</dt>
            <dd><input type="number" step="0.1" value="${dish.price}" name="price" required></dd>
        </dl>
        <dl>
            <dt>Date:</dt>
            <dd><input type="date" value="${dish.date}" name="date" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
