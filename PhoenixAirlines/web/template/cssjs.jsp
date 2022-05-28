<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header class="header">
            <div id="menu-btn" class="fas fa-bars"></div>
            <a data-aos="zoom-in-left" data-aos-delay="150" class="logo"><img src="assets/media/logo.png" alt="" align="center">Phoenix Airlines </a>
            <nav class="navbar">
                <a data-aos="zoom-in-left" data-aos-delay="300" href="#home">home</a>
                <a data-aos="zoom-in-left" data-aos-delay="450" href="#about">about</a>
                <a data-aos="zoom-in-left" data-aos-delay="600" href="#destination">destination</a>
                <a data-aos="zoom-in-left" data-aos-delay="750" href="#services">services</a>
                <a data-aos="zoom-in-left" data-aos-delay="900" href="#gallery">gallery</a>
            </nav>
            <a data-aos="zoom-in-left" data-aos-delay="1300" class="btn" href="login.jsp">Sign in</a>
        </header>


        <jsp:include page="assets/footer.jsp" />  
        <jsp:include page="assets/footer.jsp" />  
        <jsp:include page="assets/navbar.jsp" />  



    </body>
</html>
