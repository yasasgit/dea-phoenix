<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Phoenix Airlines</title>
        <link href="assets/main.css" rel="stylesheet" type="text/css">
    </head>

    <body>
    <video autoplay muted loop id="background">
        <source src="assets/background.mp4" type="video/mp4">
    </video>
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form action="register.jsp">
                <h1>Create Account</h1>
                <span>Use your email for registration</span>
                <input type="email" placeholder="Email" />
                <input type="text" placeholder="Userame" />
                <button>Sign Up</button>
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form name="login" action="<%=request.getContextPath()%>/LoginServlet" method="post">
                <h1>Sign in</h1>
                <span>Use your username and password</span>
                <input type="text" placeholder="Username" name="username" />
                <input type="password" placeholder="Password" name="password" />
                <span style="color:red">
                    <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
                </span>
                <a href="#">Forgot your password?</a>
                <button type="submit" value="Login">Sign In</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, There !</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/signin-signup.js"></script>
</body>

</html>