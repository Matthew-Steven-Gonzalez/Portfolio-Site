<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

    <div class="container">
        <div class = "row">
        <card class="col-4">
            <img alt="user Image" class="rounded mx-auto d-block">
            <h4>${sessionScope.user.username}</h4>
            <p>Messages</p>
            <form action="/users/edit" method="get">
                <button type="submit" value="${sessionScope.user.id}" name="editMe">Edit User</button>
            </form>
            <form action="/users/delete" method="post">
                <button type="submit" value="${sessionScope.user.username}" name="deleteMe">Delete User</button>
            </form>
        </card>
        </div>
    </div>



</body>
</html>
