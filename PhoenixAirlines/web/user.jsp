<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>User Page</title>
    </head>
    <% //In case, if Admin session is not set, redirect to Login page
        if ((request.getSession(false).getAttribute("user") == null)) {
    %>
    <jsp:forward page="/login.jsp"></jsp:forward>
    <%}%>
    <body>
        <jsp:include page="assets/navbar.jsp" />  
        <center><h2>User Home</h2></center>
        Welcome <%=session.getAttribute("user")%>
        <div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
        <jsp:include page="assets/footer.jsp" />  
    </body>
</html>