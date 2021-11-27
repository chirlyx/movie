<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<h3>Please log in:</h3>
<form name="login-form" action="${pageContext.request.contextPath}/controller?command=login" method="post">
    <label for="login-input">Login:</label>
    <input id="login-input" type="text" name="login" value=""/>
    <br>
    <label for="password-input">Password:</label>
    <input id="password-input" type="password" name="password" value=""/>
    <br/>
  <c:if test="${requestScope.errorLogin != null}">
      ${requestScope.errorLogin}
  </c:if>
    <input type="submit" value="Log in"/>
    <a href="${pageContext.request.contextPath}/controller?command=sign_up_page">Sign up</a>

</form>
</body>
</html>