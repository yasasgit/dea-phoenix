<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
    <h1>Flight</h1>

    <%
        if ((request.getAttribute("view_flight") != null)) {
            List data = new ArrayList();
            data = (List) request.getAttribute("view_flight");
            Iterator itr = data.iterator();
            while (itr.hasNext()) {
    %>
    <form action="CreateTicketServlet" method="POST">
        <table border="1">
            <tbody>
                <tr>
                    <td>TO</td>
                    <td><%=itr.next()%></td>
                </tr>
                <tr>
                    <td>Air Time</td>
                    <td><%=itr.next()%></td>
                </tr>
                <tr>
                    <td>Takeoff Date</td>
                    <td><%=itr.next()%></td>
                </tr>
                <tr>
                    <td>From</td>
                    <td><%=itr.next()%></td>
                </tr>
                <tr>
                    <td>Land Time</td>
                    <td><%=itr.next()%></td>
                </tr>
                <tr>
                    <td>Land Date</td>
                    <td><%=itr.next()%></td>
                </tr>
                <tr>
                    <td>Gate</td>
                    <td><%=itr.next()%></td>
                </tr>
                <tr>
                    <td>Cost</td>
                    <td><input type="text" name="cost" value="<%=itr.next()%>" readonly="readonly" /></td>
                </tr>
                <tr>
                    <td>Aircraft</td>
                    <td><%=itr.next()%></td>
                </tr>
            <input type="hidden" name="flight_id" value="<%=itr.next()%>" readonly="readonly" />
            <tr>
                <td>Class</td>
                <td><select name="class" required>
                        <option value="101">1st class</option>
                        <option value="102">Business</option>
                        <option value="103">Economy</option>
                    </select></td>
            </tr>
            <tr>
                <td>Seat</td>
                <td><select name="seatNumber" required>
                        <option value="1">1A</option>
                        <option value="2">B1</option>
                        <option value="3">C1</option>
                    </select></td>
            </tr>
            <tr>
                <td>Number of seats</td>
                <td><input type="text" name="seats" value="" size="3" /></td>
            </tr>
            <tr>
                <td><input type="reset" value="Cancel" /></td>
                <td><input type="submit" value="Book Reservation" /></td>
            </tr>
            </tbody>

        </table>
    </form> 
    <%}
        }%>
    <jsp:include page="assets/footer.jsp" />  
</body>
</html>
