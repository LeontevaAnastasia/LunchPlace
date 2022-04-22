<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Restaurant list</title>

</head>
<body>
<h3><a href="index.jsp">Home</a></h3>
<section>
    <hr/>
    <h2>Restaurant</h2>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Restaurant</th>
            <th>Vote</th>


        </tr>
        </thead>
        <c:forEach items="${restaurants}" var="restaurant">
        <jsp:useBean id="restaurant" type="com.lanchplace.model.Restaurant"/>
            </tr>
        <td>${restaurant.name}</td
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>