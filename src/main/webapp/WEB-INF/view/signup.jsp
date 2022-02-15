<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie | Sign Up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}static/css/signup.css"/>
</head>
<body>
<section class="container-fluid">
    <section class="row justify-content-center">
        <section class="col-12 col-sm-6 col-md-3">
            <form class="form-container needs-validation" action="${pageContext.request.contextPath}/controller?command=sign_up"
                  method="post" novalidate>
                <div class="form-group">
                    <h1>Sign Up</h1>
                    <p>Please fill in this form to create an account.</p>
                    <hr>
                    <label for="inputLogin">Login</label>
                    <input id="inputLogin" type="text" class="form-control" name="login"
                           pattern="^[a-zA-Z0-9]{4,25}$"
                           title="4 or more characters"
                           placeholder="Login" required>
                    <div class="valid-feedback">Input format is correct</div>
                    <div class="invalid-feedback">
                        Please notice that the login can contain only latin letters and numbers and should be between 4 and 25 symbols long.
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input id="inputPassword" type="password" class="form-control" name="password"
                           pattern="^[a-zA-Z0-9]{8,50}$"
                           title="8 or more characters"
                           placeholder="Password" required>
                    <div class="valid-feedback">Input format is correct</div>
                    <div class="invalid-feedback">
                        Please notice that the password can contain only latin letters and numbers and should be between 8 and 50 symbols long.
                    </div>
                    <small id="passwordHelp" class="form-text text-muted">Your password must be 8-50 characters long,
                        contain
                        letters and numbers, and must not contain spaces, special characters, or emoji.</small>
                </div>
                <div class="form-group">
                    <label for="inputFirstName">First name</label>
                    <input type="text" class="form-control" id="inputFirstName" name="firstName"
                           pattern="^[a-zA-Z]{2,35}$"
                           title="2 or more characters"
                           placeholder="First name" required>
                    <div class="valid-feedback">Input format is correct</div>
                    <div class="invalid-feedback">
                        Please notice that the field can contain only latin letters and should be between 2 and 35 symbols long.
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputLastName">Last name</label>
                    <input type="text" class="form-control" id="inputLastName" name="lastName"
                           pattern="^[a-zA-Z]{2,35}$"
                           title="2 or more characters"
                           placeholder="Last name" required>
                    <div class="valid-feedback">Input format is correct</div>
                    <div class="invalid-feedback">
                        Please notice that the field can contain only latin letters and should be between 2 and 35 symbols long.
                    </div>
                </div>
                <c:if test="${requestScope.errorLogin != null}">
                    <br>
                    ${requestScope.errorLogin}
                    <br>
                </c:if>
                <button type="submit" class="btn btn-primary">Sign up</button>
            </form>
        </section>
    </section>
</section>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/form-validation.js"></script>

</body>
</html>
