<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie | Movie</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<jsp:include page="element/header.jsp"/>

<section class="bg-light">
    <div class="container-lg">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="list-group">
                    <div class="list-group-item py-3 my-3">
                        <h4 class="mb-1">${requestScope.movie.id} ${requestScope.movie.title}, ${requestScope.movie.year}</h4>
                        <hr>
                        <p class="mb-1">Category: ${requestScope.movie.category}</p>
                        <p class="mb-1">Actors:
                            <c:forEach var="actor" items="${requestScope.movie.actorList}">
                                ${actor.name}
                            </c:forEach>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="element/footer.jsp"/>

</body>
</html>
