<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Users | Movie</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/prevent-back-button.js"></script>--%>
</head>
<body>

<jsp:include page="element/header.jsp"/>

<section class="bg-light">
    <div class="container-lg">
        <div class="row justify-content-center mx-0">
            <div class="col-lg-8">
                <h1 class="mx-lg-4 my-3">
                    Users List
                    <small class="text-muted">Page ${currentPage} out of ${numberOfPages}</small>
                </h1>
                <hr>
                <div class="list-group">
                    <c:forEach var="user" items="${requestScope.users}">
                        <div class="list-group-item py-3 my-2">
                            <h5 class="mb-1">
                                <a href="${pageContext.request.contextPath}/controller?command=edit_user&user=${user.id}">${user.firstName} ${user.lastName})</a>
                            </h5>
                            <hr>
                            <p class="mb-1">Current status: ${user.status}</p>
                            <form class="form-container"
                                  action="${pageContext.request.contextPath}/controller?command=update_status&user=${user.id}"
                                  method="post">
                                <div class="form-group">
                                    <label for="inputStatus">Change into:</label>
                                    <select class="form-control" name="status" id="inputStatus">
                                        <c:forEach var="status" items="${requestScope.statuses}">
                                                <option>${status}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">Update</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
                <nav aria-label="Page navigation">
                    <ul class="pagination justify-content-center">
                        <c:forEach begin="1" end="${numberOfPages}" var="i">
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <li class="page-item disabled"><a class="page-link"
                                                                      href="controller?command=show_users&page=${i}">${i}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item"><a class="page-link"
                                                             href="controller?command=show_users&page=${i}">${i}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</section>

<jsp:include page="element/footer.jsp"/>

</body>
</html>
