<%--
  Created by IntelliJ IDEA.
  User: nicolesweeden
  Date: 2/15/23
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit an Ad" />
    </jsp:include>

<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<body>
<div class="container">
    <h1>Edit an Ad</h1>
    <form action="/edit-ad/*" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" placeholder="${ad.title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text" placeholder="${ad.description}"></textarea>
        </div>
            <Button type="submit" value="${editMe}" name="editMe"> finalized edit</Button>
    </form>
</div>

</body>
</html>



