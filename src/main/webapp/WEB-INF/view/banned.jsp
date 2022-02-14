<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/banned.css"/>

</head>
<body>
<jsp:include page="element/header.jsp"/>
<section class="bg-light">
    <div class="container-lg">
        <div class="row justify-content-center mx-0">
            <div class="col-lg-8">
                <div class="list-group">
                    <div class="list-group-item py-3 my-3">
                        <h2 class="mb-1">Your account is banned</h2>
                        <hr>
                        <p class="mb-1">While banned, no service is available.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
</body>
</html>
