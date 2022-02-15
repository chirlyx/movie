<%@ taglib prefix="ct" uri="timeTag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<fmt:setLocale value="${cookie.lang.value}" />
<fmt:setBundle basename="l10n.page.main" var="loc" />
<fmt:message bundle="${loc}" key="label.title" var="title" />
<fmt:message bundle="${loc}" key="label.firstSubheadingOne" var="firstSubheadingOne" />
<fmt:message bundle="${loc}" key="label.firstSubheadingTwo" var="firstSubheadingTwo" />
<fmt:message bundle="${loc}" key="label.firstParagraph" var="firstParagraph" />
<fmt:message bundle="${loc}" key="label.secondHeading" var="secondHeading" />
<fmt:message bundle="${loc}" key="label.thirdHeading" var="thirdHeading" />
<fmt:message bundle="${loc}" key="label.adminLi1" var="adminLi1" />
<fmt:message bundle="${loc}" key="label.adminLi2" var="adminLi2" />
<fmt:message bundle="${loc}" key="label.adminLi3" var="adminLi3" />
<fmt:message bundle="${loc}" key="label.adminLi4" var="adminLi4" />
<fmt:message bundle="${loc}" key="label.forthHeading" var="forthHeading" />
<fmt:message bundle="${loc}" key="label.userLi1" var="userLi1" />
<fmt:message bundle="${loc}" key="label.userLi2" var="userLi2" />
<fmt:message bundle="${loc}" key="label.userLi3" var="userLi3" />
<fmt:message bundle="${loc}" key="label.userLi4" var="userLi4" />

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

<div class=" height position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center gradient-right">

    <img src="${pageContext.request.contextPath}/static/data/first.jpg" alt="alt" class="main-image">

    <div class="w-50 col-md-5 p-lg-5 my-5 main-text right-align">
        <h1 class="display-4 font-weight-normal">${title}</h1>
        <h2>${firstSubheadingOne} <ct:time/>${firstSubheadingTwo}</h2>
        <p class="lead font-weight-normal">
            ${firstParagraph}
        </p>
    </div>
</div>

<div class="height position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center gradient-left" >

    <img src="${pageContext.request.contextPath}/static/data/second.jpg" alt="alt" class="main-image">

    <div class="col-md-5 p-lg-5 my-5 main-text left-align" >
        <h1 class="display-4 font-weight-normal">${secondHeading}</h1>
        <ul class="lead font-weight-normal text-white">
            <li>Java 8</li>
            <li>Java EE (Java Servlets, JSP, JSTL)</li>
            <li>JDBC</li>
            <li>Slf4j&Logback</li>
            <li>Apache Tomcat 9</li>
            <li>MySQL</li>
        </ul>
    </div>
</div>

<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center gradient-right">

    <img src="${pageContext.request.contextPath}/static/data/third.jpg" alt="alt" class="main-image">

    <div class="col-md-5 p-lg-5 my-5 main-text right-align">
        <h1 class="display-4 font-weight-normal">${thirdHeading}</h1>
        <ul class="lead font-weight-normal text-white ul-additional">
            <li>${adminLi1}</li>
            <li>${adminLi2}</li>
            <li>${adminLi3}</li>
            <li>${adminLi4}</li>
        </ul>
    </div>
    <div class="product-device box-shadow d-none d-md-block"></div>
    <div class="product-device product-device-2 box-shadow d-none d-md-block"></div>
</div>

<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center gradient-left">

    <img src="${pageContext.request.contextPath}/static/data/forth.jpg" alt="alt" class="main-image">

    <div class="col-md-5 p-lg-5 my-5 main-text left-align">
        <h1 class="display-4 font-weight-normal">${forthHeading}</h1>
        <ul class="lead font-weight-normal text-white">
            <li>${userLi1}</li>
            <li>${userLi2}</li>
            <li>${userLi3}</li>
            <li>${userLi4}</li>
        </ul>
    </div>
    <div class="product-device box-shadow d-none d-md-block"></div>
    <div class="product-device product-device-2 box-shadow d-none d-md-block"></div>
</div>

<jsp:include page="element/footer.jsp"/>
</body>
</html>
