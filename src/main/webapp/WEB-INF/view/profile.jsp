<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile | Movie</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fit-screen.css"/>
    <%-- <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/prevent-back-button.js"></script>--%>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>

</head>
<body>

<jsp:include page="element/header.jsp"/>

<section class="bg-light fit">
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
                        <p class="mb-1"><b>Status:</b> ${sessionScope.user.status.name}</p>

                        <div class="card border-info my-3" style="width: 18rem;">
                            <div class="card-header">
                                How status system works:
                            </div>
                            <ul class="list-group list-group-flush">
                                <c:forEach var="status" items="${requestScope.statuses}">
                                    <li class="list-group-item"><b>${status.name}</b> > ${status.bottomValue} reviews</li>
                                </c:forEach>
                            </ul>
                        </div>

                        <div class="card mt-3">
                            <div class="card-header">
                                <h5>My reviews (${requestScope.count})</h5>
                            </div>
                            <div class="card-body">
                                <c:forEach var="movie" items="${requestScope.movies}">
                                    ☑ ${movie.title}
                                    <a href="${pageContext.request.contextPath}/controller?command=delete_review_from_profile&movie=${movie.id}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                    </svg>
                                    </a>
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
