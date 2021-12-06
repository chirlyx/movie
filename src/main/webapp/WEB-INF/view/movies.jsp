<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie | Movie List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

<jsp:include page="element/header.jsp"/>

<section class="bg-light">
    <div class="container-lg">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <h1 class="mx-lg-4 my-3">
                    Movie List
                    <small class="text-muted">Page ${currentPage} out of ${numberOfPages}</small>
                </h1>
                <div class="list-group">
                    <c:forEach var="movie" items="${requestScope.movies}">
                        <div class="list-group-item py-3 my-2 ">
                            <h5 class="mb-1"><a
                                    href="${pageContext.request.contextPath}/controller?command=single_movie_page&movie=${movie.id}">${movie.title}</a>
                                (${movie.id})</h5>
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
