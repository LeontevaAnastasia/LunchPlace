<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:setBundle basename="messages.app"/>
<header>
    <a href="restaurants"><spring:message code="app.title"/></a> | <a href="users"><spring:message code="user.title"/></a> | <a href="index.jsp"><spring:message code="app.home"/></a>
</header>