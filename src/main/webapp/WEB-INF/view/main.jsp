<%@ taglib prefix="ct" uri="timeTag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<fmt:setLocale value="${cookie.lang.value}" />
<fmt:setBundle basename="l10n.page.main" var="loc" />
<fmt:message bundle="${loc}" key="label.title" var="pageTitle" />
<html>
<head>
    <title>Movie | Main</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/prevent-back-button.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css"/>

</head>
<body>
<jsp:include page="element/header.jsp"/>

<div class=" height position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center" id="gradient">
    <img src="https://images.unsplash.com/photo-1497215728101-856f4ea42174?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80" alt="alt" class="main-image">

    <div class="w-50 col-md-5 p-lg-5 my-5" id="main-text">
        <h1 class="display-4 font-weight-normal">${pageTitle}</h1>
        <h2>It's already <ct:time/> o'clock, high time you watched some movies!</h2>
        <p class="lead font-weight-normal">
            We present to you a personal movie diary. Our team offers a selected number of movies you can choose from, while you can leave reviews.
        </p>
        <a class="btn btn-outline-secondary" href="#">Coming soon</a>
    </div>
</div>

<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light" >
    <div class="col-md-5 p-lg-5 mx-auto my-5">
        <h1 class="display-4 font-weight-normal">Punny headline</h1>
        <p class="lead font-weight-normal">And an even wittier subheading to boot. Jumpstart your marketing efforts with this example based on Apple's marketing pages.</p>
        <a class="btn btn-outline-secondary" href="#">Coming soon</a>
    </div>
</div>

<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center" style="background-color: #dee3ed">
    <div class="col-md-5 p-lg-5 mx-auto my-5">
        <h1 class="display-4 font-weight-normal">Punny headline</h1>
        <p class="lead font-weight-normal">And an even wittier subheading to boot. Jumpstart your marketing efforts with this example based on Apple's marketing pages.</p>
        <a class="btn btn-outline-secondary" href="#">Coming soon</a>
    </div>
    <div class="product-device box-shadow d-none d-md-block"></div>
    <div class="product-device product-device-2 box-shadow d-none d-md-block"></div>
</div>

<jsp:include page="element/footer.jsp"/>
</body>
</html>
