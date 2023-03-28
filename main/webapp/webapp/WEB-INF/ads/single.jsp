
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp"/>
    <title>View Single Ad</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <div class="col-md-6 justify-content-center">
        <h1> Title: ${Ad.title} </h1>
        <h3> Description: ${Ad.description}</h3>
<%--        <h3>Categories would go here: </h3>--%>
    </div>
</div>
</body>
</html>


