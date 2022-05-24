<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Grade 1 Staff Page</title>
    </head>
    <% //In case, if StaffG1 session is not set, redirect to Login page
        if ((request.getSession(false).getAttribute("staffg1") == null)) {
    %>
    <jsp:forward page="/login.jsp"></jsp:forward>
    <%}%>
    <body>
        <jsp:include page="assets/navbar.jsp" />  
        <center><h2>Grade 1 Staff Home</h2></center>
        Welcome <%=session.getAttribute("staffg1")%>

        <h1>Update Flight Details</h1>
        <div>
            <form method="post" action="<%=request.getContextPath()%>/UpdateFlightInfoServlet">
                Flight id <input type="text" name="flightId"/><br>
                AirCraft Id <input type="text" name="aircraft_id"/><br> 
                Takeoff_airport  <input type="text" name="takeoff_airport"/><br>
                Takeoff Time  <input type="text" name="takeoff_time"/><br>
                Takeoff Date  <input type="text" name="takeoff_date"/><br>
                Landing airport  <input type="text" name="landing_airport"/><br>
                Landing Time  <input type="text" name="landing_time"/><br>
                Landing Date  <input type="text" name="landing_date"/><br>
                Gate No <input type="text" name="gate"/><br>
                Cost <input type="text" name="cost"/><br>
                <input type="submit" name="Update Flight Details"/>
                <input type="reset" name="Cancel"/>
            </form>
        </div>

        <h1>Delete Flight Record</h1>
        <div>
            <form method="post" action="DeleteFlightInfoServlet">
                Enter Flight id to delete :<input type="text" name="flightId"/><br>
                <input type="submit" name="DeleteFlightRecord"/>
                <input type="reset" name="Cancel"/>
            </form>
        </div>       

        <div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
        <jsp:include page="assets/footer.jsp" />  
    </body>
</html>