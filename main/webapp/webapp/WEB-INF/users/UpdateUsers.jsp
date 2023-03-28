<%--
  Created by IntelliJ IDEA.
  User: muffins
  Date: 2/16/23
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Edit your ad" />
        </jsp:include>
    </head>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Please fill in your new information.</h1>
    <form action="/users/edit" method="post">
        <div class="form-group">
            <label for="username">Updated Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="email">Update Email</label>
            <input id="email" name="email" class="form-control" type="text">
        </div>
        <button type="submit" value="${sessionScope.user.id}" name="editMe">Edit User</button>
    </form>
</div>
</body>
</html>
