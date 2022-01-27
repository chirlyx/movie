<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie | Movie List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/prevent-back-button.js"></script>
</head>
<body>

<jsp:include page="element/header.jsp"/>

<section class="bg-light">
    <div class="container-lg">
        <div class="row justify-content-center mx-0">
            <div class="col-lg-8">
                <h1 class="mx-lg-4 my-3">
                    Movie List
                    <small class="text-muted">Page ${currentPage} out of ${numberOfPages}</small>
                </h1>
                <hr>
                <c:if test="${sessionScope.account.isAdmin()}">
                    <div class="card bg-secondary mb-3">
                        <div class="card-body">
                            <h3><a class="nav-link text-white text-center"
                                   href="controller?command=edit_movie&movie=new">Add a
                                movie +</a></h3>
                        </div>
                    </div>
                </c:if>
                <%--<img src="${pageContext.request.contextPath}/img/flower.png">--%>
                <div class="list-group">
                    <c:forEach var="movie" items="${requestScope.movies}">
                        <div class="list-group-item py-3 my-2">
                            <h5 class="mb-1">
                                <c:if test="${sessionScope.account.isAdmin()}">
                                    <a href="${pageContext.request.contextPath}/controller?command=edit_movie&movie=${movie.id}">${movie.title}</a>
                                </c:if>
                                <c:if test="${sessionScope.account.isUser()}">
                                    <a href="${pageContext.request.contextPath}/controller?command=single_movie_page&movie=${movie.id}">${movie.title}</a>
                                </c:if>
                                (${movie.id})
                            </h5>
                            <hr>
                            <p class="mb-1">Year: ${movie.year}</p>
                            <p class="mb-1">Category: ${movie.category}</p>
                        </div>
                    </c:forEach>
                </div>
                <table border="1" cellpadding="5" cellspacing="5">
                    <tr>
                        <c:forEach begin="1" end="${numberOfPages}" var="i">
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <td>${i}</td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="controller?command=show_movies&page=${i}">${i}</a></td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="element/footer.jsp"/>

</body>
</html>
