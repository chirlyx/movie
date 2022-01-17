<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark sticky-top" style="background-color: #231f20">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="controller?command=main_page">Main</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=show_movies&page=1">Movies</a>
            </li>
            <c:if test="${sessionScope.account.isUser()}">
            <li class="nav-item">
                <a class="nav-link" href="#">Profile</a>
            </li>
            </c:if>
            <c:if test="${sessionScope.account.isAdmin()}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=show_users&page=1">Users</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>