<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <form class="form-container" action="${pageContext.request.contextPath}/controller?command=sign_up"
                  method="post">
                <div class="form-group">
                    <h1>Sign Up</h1>
                    <p>Please fill in this form to create an account.</p>
                    <hr>
                    <label for="inputLogin">Login</label>
                    <input id="inputLogin" type="text" class="form-control" name="login" placeholder="Login">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input id="inputPassword" type="password" class="form-control" name="password" placeholder="Password">
                    <small id="passwordHelp" class="form-text text-muted">Your password must be 8-20 characters long,
                        contain
                        letters and numbers, and must not contain spaces, special characters, or emoji.</small>
                </div>
                <div class="form-group">
                    <label for="inputFirstName">First name</label>
                    <input type="text" class="form-control" id="inputFirstName" name="firstName" placeholder="First name">
                </div>
                <div class="form-group">
                    <label for="inputLastName">Last name</label>
                    <input type="text" class="form-control" id="inputLastName" name="lastName" placeholder="Last name">
                </div>
                <button type="submit" class="btn btn-primary">Sign up</button>
            </form>
        </section>
    </section>
</section>
</body>
</html>
