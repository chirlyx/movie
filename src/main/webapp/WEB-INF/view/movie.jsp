<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie | Movie</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/movie-poster.css"/>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/prevent-back-button.js"></script>--%>
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
                        <div>
                            <div class="item">
                                <img class="mr-3" src="${pageContext.request.contextPath}/static/data/${movie.id}.jpg">
                            </div>
                            <h2 class="mb-1">${requestScope.movie.title}, ${requestScope.movie.year}
                                (${requestScope.movie.id})</h2>
                            <hr>
                            <p class="mb-1">Description: ${requestScope.movie.description}</p>
                            <p class="mb-1">Category: ${requestScope.movie.category.name}</p>
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class="card mt-3">
                            <div class="card-header">
                                <h5>Review</h5>
                            </div>
                            <c:if test="${!requestScope.isReview}">
                                <div class="card-body">
                                    <h6 class="card-title">Rate the movie and leave a comment here:</h6>
                                    <form name="review-form" class="form-container needs-validatio"
                                          action="${pageContext.request.contextPath}/controller?command=submit_review&movie=${requestScope.movie.id}"
                                          method="post"
                                          novalidate>
                                        <div class="form-group row">
                                            <label for="movieName" class="col-sm-2 col-form-label">Movie</label>
                                            <div class="col-sm-10">
                                                <input type="text" readonly class="form-control-plaintext"
                                                       id="movieName" value="${requestScope.movie.title}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="mark" class="col-sm-2 col-form-label">Mark:</label>
                                            <div class="col-sm-10">
                                                <select class="form-control" name="mark" id="mark">
                                                    <option>0</option>
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="comment" class="col-sm-2 col-form-label">Comment:</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="comment" id="comment"
                                                          rows="3" required></textarea>
                                            </div>
                                        </div>
                                        <p class="card-text">With supporting text below as a natural lead-in to
                                            additional content.</p>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </form>
                                </div>
                            </c:if>
                            <c:if test="${requestScope.isReview}">
                                <div class="card-body">
                                    <h6 class="card-title">Your review:</h6>
                                    <form name="review-form" class="form-container"
                                          action="${pageContext.request.contextPath}/controller?command=delete_review&movie=${requestScope.movie.id}"
                                          method="post">
                                        <div class="form-group row">
                                            <label for="reviewMovieName" class="col-sm-2 col-form-label">Movie</label>
                                            <div class="col-sm-10">
                                                <input type="text" readonly class="form-control-plaintext"
                                                       id="reviewMovieName" value="${requestScope.movie.title}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="reviewMark" class="col-sm-2 col-form-label">Mark</label>
                                            <div class="col-sm-10">
                                                <input type="text" readonly class="form-control-plaintext"
                                                       id="reviewMark" value="${requestScope.mark}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="reviewComment" class="col-sm-2 col-form-label">Comment</label>
                                            <div class="col-sm-10">
                                                <input type="text" readonly class="form-control-plaintext"
                                                       id="reviewComment" value="${requestScope.comment}">
                                            </div>
                                        </div>
                                        <p class="card-text">Click the button if you want to delete your review.</p>
                                        <button type="submit" class="btn btn-primary">Delete</button>
                                    </form>
                                </div>
                            </c:if>
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
