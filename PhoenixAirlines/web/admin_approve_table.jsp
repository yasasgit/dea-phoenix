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
                    <li><a href="admin_dashboard.jsp">Dashboard</a></li>
                    <li class="active"><a href="admin_approve_table.jsp">Approve Staff</a></li>
                    <li><a href="admin_monitor_table.jsp">Monitor Users</a></li>
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
            <h1>Admin Dashboard</h1>
            <p>
                Welcome <%=session.getAttribute("admin")%>!
            </p>
        </div>
    </div>
    <%
        if ((request.getAttribute("approve_table") == null)) {
            request.getRequestDispatcher("ApproveTableServlet").forward(request, response);
        }
    %>
    <%
        if ((request.getAttribute("approve_table") != null)) {
            List data = new ArrayList();
            data = (List) request.getAttribute("approve_table");
            Iterator itr = data.iterator();
    %>
    <table border="1">
        <thead>
        <th>First Name</th>
        <th>Last Name </th>
        <th>User Type</th>
        <th>Approve</th>
    </thead>
    <tbody>
        <%while (itr.hasNext()) {%>
    <form action="ApproveUserServlet" method="GET">
        <tr>
        <input type="hidden" name="user_id" value="<%=itr.next()%>" />
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><%=itr.next()%></td>
        <td><input type="submit" value="Approve" /></td>
        </tr>
    </form>
    <%}%>
</tbody>
</table>
<%}%>
<%
    if ((request.getAttribute("result") != null)) {%>
<h1><%=request.getAttribute("result")%></h1>
<%}%>
<jsp:include page="assets/footer.jsp" />  
</body>
</html>
