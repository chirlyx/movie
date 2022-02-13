<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css"/>
<!DOCTYPE html>
<html>
<head>
    <title>Movie | Log In</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/signup.css"/>
</head>
<body>
<!--<section class="container-fluid">
    <section class="row justify-content-center">
        <section class="col-12 col-sm-6 col-md-3">

            <form name="login-form" class="form-container"
                  action="${pageContext.request.contextPath}/controller?command=login" method="post">
                <h3>Please log in:</h3>
                <hr>
                <div class="wrapper__content">
                    <div class="labels mr-3 my-2">
                        <label for="login-input">Login:</label>
                        <label for="password-input">Password:</label>
                    </div>
                    <div class="inputs my-2">
                        <input id="login-input" type="text" name="login" value="" required/>
                        <div class="valid-feedback">Looks good!</div>
                        <input id="password-input" type="password" name="password" value="" required/>
                    </div>
                </div>

                <c:if test="${requestScope.errorLogin != null}">
                    ${requestScope.errorLogin}
                </c:if>
                <div class="buttons">
                    <div class="mr-2">
                        <input type="submit" value="Log in"/>
                    </div>
                    <div>
                        <a href="${pageContext.request.contextPath}/controller?command=sign_up_page">Sign up</a>
                    </div>
                </div>
            </form>
        </section>
    </section>
</section>-->
<section class="container-fluid">
    <section class="row justify-content-center">
        <section class="col-12 col-sm-6 col-md-3">
            <form class="form-container needs-validation"
                  action="${pageContext.request.contextPath}/controller?command=login"
                  method="post"
                  novalidate>
                <h3>Please log in:</h3>
                <hr>

                <div class="form-row">
                    <div class="col-md-12 mb-3">
                        <label for="login-input">Login:</label>
                        <input id="login-input" type="text" name="login" class="form-control"
                               pattern=".{4,}"
                               title="4 or more characters"
                               placeholder="Login" required>
                        <div class="valid-feedback">Input format is correct</div>
                        <div class="invalid-feedback">
                            Please, make sure the login is more than 4 symbols long.
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-12 mb-3">
                        <label for="password-input">Password:</label>
                        <input id="password-input" type="password" name="password" class="form-control"
                               pattern=".{8,}"
                               title="8 or more characters"
                               placeholder="Password" required>
                        <div class="valid-feedback">Input format is correct</div>
                        <div class="invalid-feedback">
                            Please make sure the password is more than 8 symbols long.
                        </div>
                    </div>
                </div>

                <c:if test="${requestScope.errorLogin != null}">
                    ${requestScope.errorLogin}
                    <br>
                </c:if>

                <button class="btn btn-primary" type="submit">Log in</button>

                <a href="${pageContext.request.contextPath}/controller?command=sign_up_page">Sign up</a>
            </form>
        </section>
    </section>
</section>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/form-validation.js"></script>

</body>
</html>