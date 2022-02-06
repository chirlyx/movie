<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile | Movie</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/prevent-back-button.js"></script>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>

</head>
<body>

<jsp:include page="element/header.jsp"/>

<section class="bg-light">
    <div class="container-lg">
        <div class="row justify-content-center mx-0">
            <div class="col-lg-8">
                <div class="list-group">
                    <div class="list-group-item py-3 my-3">
                        <h2 class="mb-1">My profile</h2>
                        <hr>

                        <h5>Information</h5>
                        <p class="mb-1"><b>First name:</b> ${sessionScope.user.firstName}</p>
                        <p class="mb-1"><b>Last name:</b> ${sessionScope.user.lastName}</p>
                        <p class="mb-1"><b>Login:</b> ${sessionScope.account.login}</p>
                        <p class="mb-1"><b>Status:</b> ${sessionScope.user.status.name()}</p>

                        <div class="card mt-3">
                            <div class="card-header">
                                <h5>My reviews (${requestScope.count})</h5>
                            </div>
                            <div class="card-body">
                                <c:forEach var="movie" items="${requestScope.movies}">
                                    <a href="${pageContext.request.contextPath}/controller?command=single_movie_page&movie=${movie.id}">${movie.title}</a>
                                    <br>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="element/footer.jsp"/>

</body>
</html>
