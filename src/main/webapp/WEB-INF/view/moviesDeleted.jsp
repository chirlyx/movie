<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleted Movies</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/movie-poster.css"/>
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
                <a class="btn btn-outline-dark mb-1 ml-4" href="controller?command=show_movies&page=1" role="button">Active movies</a>
                <a class="btn btn-secondary disabled mb-1" href="#" role="button">Deleted movies</a>
                <hr>
                <div class="list-group">
                    <c:forEach var="movie" items="${requestScope.movies}">
                        <div class="list-group-item py-3 my-2">
                            <div class="item">
                                <img class="mr-3" src="${pageContext.request.contextPath}/static/data/${movie.id}.jpg">
                            </div>
                            <h5 class="my-1 ml-3">
                                    <a href="${pageContext.request.contextPath}/controller?command=edit_movie&movie=${movie.id}">${movie.title}</a>
                                (${movie.id})
                            </h5>

                            <hr>
                            <p class="mb-1">Year: ${movie.year}</p>
                            <p class="mb-1">Category: ${movie.category.name}</p>
                            <p class="mb-1">Description: ${movie.description}</p>
                            <a class="btn btn-outline-primary mb-1 justify-content-end" href="controller?command=restore_movie&movie=${movie.id}" role="button">Restore</a>

                        </div>
                    </c:forEach>
                </div>
                <nav aria-label="Page navigation">
                    <ul class="pagination justify-content-center">
                        <c:forEach begin="1" end="${numberOfPages}" var="i">
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <li class="page-item disabled"><a class="page-link"
                                                                      href="controller?command=show_movies&page=${i}">${i}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item"><a class="page-link"
                                                             href="controller?command=show_movies&page=${i}">${i}</a>
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
