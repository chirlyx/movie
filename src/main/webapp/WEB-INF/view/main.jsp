<%@ taglib prefix="ct" uri="timeTag" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Movie | Main</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<jsp:include page="element/header.jsp"/>

<div class=" height position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center" style="background-color: #b6c0d5">
    <div class="w-50 col-md-5 p-lg-5 mx-auto my-5">
        <h1 class="display-4 font-weight-normal">Movie diary</h1>
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
