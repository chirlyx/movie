<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${cookie.lang.value}" />
<fmt:setBundle basename="l10n.page.header" var="loc" />
<fmt:message bundle="${loc}" key="label.main" var="main" />
<fmt:message bundle="${loc}" key="label.movies" var="movies" />
<fmt:message bundle="${loc}" key="label.users" var="users" />
<fmt:message bundle="${loc}" key="label.logout" var="logout" />
<nav class="navbar navbar-expand-lg navbar-dark sticky-top" style="background-color: #231f20">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="controller?command=main_page">${main}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=show_movies&page=1">${movies}</a>
            </li>
            <c:if test="${sessionScope.account.isUser()}">
                <li class="nav-item">
                    <a class="nav-link" href="#">Profile</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.account.isAdmin()}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=show_users&page=1">${users}</a>
                </li>
            </c:if>
        </ul>
        <span class="navbar-text">
            <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=logout">${logout}</a>
    </span>
    </div>
</nav>