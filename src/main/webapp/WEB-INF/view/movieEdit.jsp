<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit movie</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/prevent-back-button.js"></script>
</head>
<body>

<jsp:include page="element/header.jsp"/>

<section class="container-fluid bg-light">

    <c:if test="${requestScope.action eq 'create'}">
        <form class="form-container" action="${pageContext.request.contextPath}/controller?command=create_movie"
              method="post">
            <h1>Add a movie to the list</h1>
            <p>Fill in the fields below.</p>
            <hr>
            <div class="form-group">
                <label for="createTitle">Title</label>
                <input id="createTitle" type="text" class="form-control" name="title" placeholder="Title">
            </div>
            <div class="form-group">
                <label for="createYear">Year</label>
                <input id="createYear" type="text" class="form-control" name="year" placeholder="Year">
            </div>
            <div class="form-group">
                <label for="createCategory">Category</label>
                <select class="form-control" name="category" id="createCategory">
                    <c:forEach var="category" items="${requestScope.categories}">
                        <option>${category}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </c:if>

    <c:if test="${requestScope.action eq 'update'}">
        <form class="form-container" action="${pageContext.request.contextPath}/controller?command=update_movie&movie=${movie.id}"
              method="post">
            <h1>Edit movie information</h1>
            <p>You can change any field of movie info or delete the record.</p>
            <hr>
            <div class="form-group">
                <label for="inputTitle">Title</label>
                <input id="inputTitle" type="text" class="form-control" name="title" placeholder="Title"
                       value="${movie.title}">
            </div>
            <div class="form-group">
                <label for="inputYear">Year</label>
                <input id="inputYear" type="text" class="form-control" name="year" placeholder="Year"
                       value="${movie.year}">
            </div>
            <div class="form-group">
                <label for="inputCategory">Category</label>
                <select class="form-control" name="category" id="inputCategory">
                    <c:forEach var="category" items="${requestScope.categories}">
                        <c:if test="${requestScope.movie.category eq category}">
                        <option selected>${category}</option>
                        </c:if>
                        <c:if test="${requestScope.movie.category ne category}">
                        <option>${category}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="${pageContext.request.contextPath}/controller?command=delete_movie&movie=${movie.id}">Delete</a>
        </form>
    </c:if>

</section>

<jsp:include page="element/footer.jsp"/>
</body>
</html>
