<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Grade 2 Staff Page</title>
    </head>
    <% //In case, if StaffG2 session is not set, redirect to Login page.
        if ((request.getSession(false).getAttribute("staffg2") == null)) {
    %>
    <jsp:forward page="/login.jsp"></jsp:forward>
    <%}%>
    <body>
        <jsp:include page="assets/navbar.jsp" />  
        <center><h2>Grade 2 Staff Home</h2></center>
        Welcome <%=session.getAttribute("staffg2")%>
        <div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
        <jsp:include page="assets/footer.jsp" />  
    </body>
</html>