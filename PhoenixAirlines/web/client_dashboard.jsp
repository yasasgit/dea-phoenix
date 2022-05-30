<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <center><h2>User Home</h2></center>
    Welcome <%=session.getAttribute("client")%>
    <div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>





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

</body>
</html>
