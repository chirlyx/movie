<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<jsp:include page="element/header.jsp"/>
<h1> Hello </h1>
<a href="${pageContext.request.contextPath}/controller?command=show_movies&page=1">show movies</a>
<jsp:include page="element/footer.jsp"/>
</body>
</html>
