<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <body>
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
                        <li><a href="client_dashboard.jsp">Dashboard</a></li>
                        <li><a href="all_flight_table.jsp">View Flights</a></li>
                        <li class="active"><a href="client_ticket_table.jsp">My Reservations</a></li>
                        <li><a href="all_profile.jsp">Profile</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<%=request.getContextPath()%>/LogoutServlet"><span class="glyphicon glyphicon-log-in"> </span> Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <%
            if ((request.getAttribute("reservationResult") == null)) {
                request.getRequestDispatcher("ViewTicketServlet").forward(request, response);
            }
        %>
        <div class="recent">
            <div class="cardheader">
                <h2>My Reservation History</h2>
            </div>
            <table border="1">
                <thead>
                    <tr>
                        <th>User First Name</th>
                        <th>Takeoff Airport</th>
                        <th>Landing Airport</th>
                        <th>Takeoff Date</th>
                        <th>Takeoff Time</th>
                        <th>Gate</th>
                        <th>Seat Number</th>
                        <th>Total Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if ((request.getAttribute("reservationResult") != null)) {
                            List data = new ArrayList();
                            data = (List) request.getAttribute("reservationResult");
                            Iterator itr = data.iterator();
                            while (itr.hasNext()) {
                    %>
                    <tr>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td><form action="userUpdateReservation.jsp" method="POST">
                                <input type="hidden" name="ticket_id" value="" />
                                <input type="submit" value="Update" />
                            </form></td>
                    </tr>
                    <%}
                        }%>
                </tbody>

            </table>
        </div>
        <jsp:include page="assets/footer.jsp" />  
    </body>
</html>
