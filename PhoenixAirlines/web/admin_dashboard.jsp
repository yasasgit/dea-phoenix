<%
    if ((request.getSession(false).getAttribute("admin") == null)) {
%>
<jsp:forward page="/login.jsp"></jsp:forward>
<%}%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
        <jsp:include page="assets/navbar.jsp" />  
        <div class="jumbotron">
            <div class="container text-center">
                <h1>Admin Dashboard</h1>
                <p>
                    Welcome <%=session.getAttribute("admin")%>!
                </p>
            </div>
        </div>

    <tbody>
        <%
            if ((request.getAttribute("approve_table") != null)) {

                List data = new ArrayList();
                data = (List) request.getAttribute("approve_table");
                Iterator itr = data.iterator();%>
    <h3>Approve New Staff Members</h3>
    <table border="1">
        <thead>
        <th>First Name</th>
        <th>Last Name </th>
        <th>User Type</th>
        <th>Approve</th>
    </thead>
    <%
        while (itr.hasNext()) {
    %>
    <form action="ApproveServlet" method="POST">
        <tr>
        <input type="hidden" name="user_id" value="<%=itr.next()%>" />
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td>
            <input type="submit" value="Approve" />
        </td>
        </tr>
    </form>
    <%}
            }%>
</tbody>
</table>
<h3>Filter Last 20 Logins</h3>
<%
    if ((request.getAttribute("monitor_table") == null)) {
        request.getRequestDispatcher("AdminTableServlet").forward(request, response);
    }
%>

<form action="SearchUsersAdminServlet" method="POST">

    <input type="text" name="search_user" value="" />
    <select name="search_type">
        <option value="email">Email</option>
        <option value="username">Username</option>
    </select>
    <input type="submit" value="View Users" name="view_users" />
</form>

<%
    if ((request.getAttribute("monitor_table") != null)) {
        List data = new ArrayList();
        data = (List) request.getAttribute("monitor_table");
        Iterator itr = data.iterator();%>
<table border="1">
    <thead>
    <th>First Name</th>
    <th>Last Name </th>
    <th>Email</th>
    <th>Username</th>
    <th>User Type</th>
    <th>IP Address</th>
    <th>Login Time</th>
</thead>
<tbody>
    <%while (itr.hasNext()) {%>
    <tr>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
    </tr>
    <%}
        }%>
</tbody>
</table>
</body>
</html>
