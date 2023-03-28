<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <li><a href="/logout">Logout</a></li>--%>
            <li>
                <form action="/ads/search" class="form-inline" method="GET">
                <input id="s" name="s" class="form-control" type="search" placeholder="Search Ads..." aria-label="Search">
                <button class="btn btn-outline-success" type="submit"><i class="fas fa-search"></i></button>
                </form>
            </li>
            <c:choose>
                <c:when test="${sessionScope['user'] != null}">
                    <li><a href="${pageContext.request.contextPath}/profile">View Profile</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                    <li><a href="${pageContext.request.contextPath}/ads/create">Create Ads</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                    <li><a href="${pageContext.request.contextPath}/register">Register</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


