<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>User Page</title>
    </head>
    <% //In case, if Admin session is not set, redirect to Login page
        if ((request.getSession(false).getAttribute("client") == null)) {
    %>
    <jsp:forward page="/login.jsp"></jsp:forward>
    <%}%>
    <body>
        <jsp:include page="assets/navbar.jsp" />  
        <center><h2>User Home</h2></center>
        Welcome <%=session.getAttribute("client")%>
        <div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>


        <h1>All Flight Details</h1>
        <h1>Search Flight Details</h1>
        <div>
            <form method="post" action="SearchFlightInfoServlet">
                Select option to Search data  
                <input type="date" name="takeoff_date" value="" />
                take off <select name="takeoff_airport">
                    <option value="AAL">AAL</option>
                    <option value="CMB">CMB</option>
                </select>
                landing <select name="landing_airport">
                    <option value="ABV">ABV</option>
                    <option value="CWL">CWL</option>
                </select>
                <input type="submit" name="Search"/>
                <input type="reset" name="Cancel"/>
            </form>
        </div>

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
            <th>Action</th>
        </thead>
        <tbody>
            <%
                if ((request.getAttribute("result") != null)) {
                    List data = new ArrayList();
                    data = (List) request.getAttribute("result");
                    Iterator itr = data.iterator();
                    while (itr.hasNext()) {
            %>
            <tr>
        <form action="GetSelectedData" method="POST">
            <td><input type="hidden" name="flightId" value="<%=itr.next()%>" readonly="readonly"/></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><input type="submit" value="Book Reservation" /></td>
        </form>


    </tr>
    <%}
        }%>
</tbody>
</table>

<form action="UpdateUserServlet" method="POST">
    <input type="submit" value="Update" />
</form>

<div>
    <form action="ViewFlightInfoServlet" method="POST">
        <input type="submit" value="Veiw All Flight Details" />
    </form>
</div>

<!--        check reservations/tickets-->
<div>
    <form action="SelectTicketServlet" method="POST">
        <input type="submit" value="Veiw My Reservation" />
    </form>
</div>

<h1>My Reservation</h1>
<div align="center">              
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


<form action="CreateTicketServlet" method="POST">
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

<jsp:include page="assets/footer.jsp" />  
</body>
</html>