<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    if ((request.getSession(false).getAttribute("client") == null)) {
%>
<jsp:forward page="/login.jsp"></jsp:forward>
<%}%>
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
                    <li class="active"><a href="client_dashboard.jsp">Dashboard</a></li>
                    <li><a href="all_flight_table.jsp">View Flights</a></li>
                    <li><a href="client_ticket_table.jsp">My Reservations</a></li>
                    <li><a href="all_profile.jsp">Profile</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<%=request.getContextPath()%>/LogoutServlet"><span class="glyphicon glyphicon-log-in"> </span> Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="jumbotron">
        <div class="container text-center">
            <h1>Client Dashboard</h1>
            <p>
                Welcome <%=session.getAttribute("client")%>!
            </p>
        </div>
    </div>




    <h1>Fill Below Reservation form to update your Reservations</h1>
    <form action="UpdateTicketServlet" method="POST">
        <table border="1">
            <%
                if ((request.getAttribute("selectedResult") != null)) {
                    List data = new ArrayList();
                    data = (List) request.getAttribute("selectedResult");
                    Iterator itr = data.iterator();
                    while (itr.hasNext()) {
            %>
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
            <%}
                }%>
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





    <section class="home" id="home">

        <div class="content">
            <a data-aos="fade-up" data-aos-delay="600" href="#" class="btn">book now</a>
        </div>

    </section>
    <section class="book-form" id="book-form">

        <form action="">
            <div data-aos="zoom-in" data-aos-delay="150" class="inputBox">
                <span>Departing Airport</span>
                <input type="text" value="">
            </div>
            <div data-aos="zoom-in" data-aos-delay="300" class="inputBox">
                <span>Destination Airport</span>
                <input type="text" value="">
            </div>
            <div data-aos="zoom-in" data-aos-delay="450" class="inputBox">
                <span>Date</span>
                <input type="date" placeholder="number of travelers" value="">
            </div>
            <input data-aos="zoom-in" data-aos-delay="600" type="submit" value="find now" class="btn">
        </form>

    </section>
    <jsp:include page="assets/footer.jsp" />  
</body>
</html>
