<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet" />
        <style>
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }
        </style>
    </head>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Phoenix Airlines</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="all_profile.jsp">Profile</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<%=request.getContextPath()%>/LogoutServlet"><span class="glyphicon glyphicon-log-in"> </span> Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <h1>Search Flight Details</h1>
    <div>
        <form method="post" action="<%=request.getContextPath()%>/SearchFlightTableServlet">
            Select option to Search data  
            <input type="date" name="takeoff_date" value="" />
            take off <input type="text" name="takeoff_airport" value="" />
            landing <input type="text" name="landing_airport" value="" />
            <input type="submit" name="Search"/>
            <input type="reset" name="Cancel"/>
        </form>
    </div>
    <h1>View Flights Table</h1>
    <%
        if ((request.getAttribute("flight_table") == null)) {
            request.getRequestDispatcher("DefaultFlightTableServlet").forward(request, response);
        }
    %>

    <%
        if ((request.getAttribute("flight_table") != null)) {
            List data = new ArrayList();
            data = (List) request.getAttribute("flight_table");
            Iterator itr = data.iterator();%>
    <table border="1">
        <thead>
        <th>ID</th>
        <th>Takeoff Airport</th>
        <th>Takeoff Time</th>
        <th>Takeoff Date</th>
        <th>Landing Airport</th>
        <th>Landing Time</th>
        <th>Landing Date</th>
        <th>Gate</th>
        <th>Cost</th>
        <th>Aircraft</th>
        <th>View</th>
            <%
                if ((request.getSession(false).getAttribute("staffg1") != null)) {
            %>
        <th>Delete</th>
            <%}
            %>
    </thead>
    <tbody>
        <% while (itr.hasNext()) {%>
        <tr>
    <form method="GET">
        <td><input type="text" name="flight_id" value="<%=itr.next()%>" readonly="readonly"/></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><input type="submit" value="View" formaction="<%=request.getContextPath()%>/ViewFlightServlet"/>
        </td>
        <%
            if ((request.getSession(false).getAttribute("staffg1") != null)) {
        %>
        <td><input type="submit" value="Delete" formaction="<%=request.getContextPath()%>/DeleteFlightServlet"/></td>
            <%}
            %>
    </form>
</tr>
<%}
    }%>
</tbody>
</table>
<%
    if ((request.getAttribute("result") != null)) {%>
<h1><%=request.getAttribute("result")%></h1>
<%}%>
<jsp:include page="assets/footer.jsp" />  
</body>
</html>
