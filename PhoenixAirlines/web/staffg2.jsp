
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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

        <form action="SearchUsers_sServlet" method="POST">
            <h3>View Users</h3>
            <input type="text" name="search_user" value="" />
            <select name="search_type">
                <option value="email">Email</option>
                <option value="username">Username</option>
            </select>
            <input type="submit" value="View Users" name="view_users" />
        </form>

        <table border="1">
            <thead>
            </thead>
            <tbody>
                <%
                    if ((request.getAttribute("result") != null)) {
                        List user_list = new ArrayList();
                        user_list = (List) request.getAttribute("result");
                        Iterator it = user_list.iterator();
                        while (it.hasNext()) {
                %>
                <tr>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                </tr>
                <%}
                    }%>
            </tbody>
        </table>


        <h1>Add Flight Details</h1>
        <form method="post" action="<%=request.getContextPath()%>/AddFlightInfoServlet">
            Flight id <input type="hidden" name="flight_Id" value="1"/><br>
            Aircraft Id <input type="text" name="aircraft_id">
            Takeoff_airport  <input type="text" name="takeoff_airport"/><br>
            Takeoff Time  <input type="text" name="takeoff_time"/><br>
            Takeoff Date  <input type="text" name="takeoff_date"/><br>
            Landing airport  <input type="text" name="landing_airport"/><br>
            Landing Time  <input type="text" name="landing_time"/><br>
            Landing Date  <input type="text" name="landing_date"/><br>
            Gate No <input type="text" name="gate"/><br>
            Cost for Flight <input type="text" name="cost">
            <input type="submit" name="Add Flight"/>
            <input type="reset" name="Cancel"/>
        </form>



        <jsp:include page="assets/footer.jsp" />  
    </body>
</html>