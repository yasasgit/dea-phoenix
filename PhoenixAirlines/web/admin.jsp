<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Bootstrap Example</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet" />
            <style>
                /* Remove the navbar's bootstrap default margin-bottom and rounded borders */
                .navbar {
                    margin-bottom: 0;
                    border-radius: 0;
                }
            </style>
        </head>
        <% //In case, if Admin session is not set, redirect to Login page
            if ((request.getSession(false).getAttribute("admin") == null)) {
        %>
        <jsp:forward page="/login.jsp"></jsp:forward>
        <%}%>
        <body>
            <jsp:include page="assets/navbar.jsp" />  
            <div class="jumbotron">
                <div class="container text-center">
                    <h1>Admin Dashboard</h1>
                    <p>
                        Welcome <%=session.getAttribute("admin")%>
                    </p>

                </div>
            </div>
            <!--when page loads show user monitor table-->
            <form name="monitor" action="<%=request.getContextPath()%>/AdminDCServlet" method="POST">
                <input type="submit" value="Monitor" name="monitor"  />
            </form>
            <%
                if ((request.getAttribute("dc") != null)) {
                    List list = new ArrayList();
                    list = (List) request.getAttribute("dc");
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        out.println(it.next());
                    }
                }

            %>
            <form action="SearchUsersServlet" method="POST">
                <h3>View Users</h3>
                <input type="text" name="search_user" value="" />
                <select name="search_type">
                    <option value="email">Email</option>
                    <option value="username">Username</option>
                </select>
                <input type="submit" value="View Users" name="view_users" />
            </form>
            <%            if ((request.getAttribute("result") != null)) {
                    List user_list = new ArrayList();
                    user_list = (List) request.getAttribute("result");
                    Iterator it = user_list.iterator();
                    while (it.hasNext()) {
                        out.println(it.next());
                    }
                }

            %>
            <div class="container-fluid bg-3 text-center">
                <h3>Number Of Active Requests</h3><br>
                <div class="row">
                    <div class="col-sm-3">
                        <p>Some text..</p>
                        <img src="logo1.jpg" class="img-responsive" style="width:100%" alt="Image">
                    </div>
                    <div class="col-sm-3">
                        <p>Some text..</p>
                        <img src="logo1.jpg" class="img-responsive" style="width:100%" alt="Image">
                    </div>
                    <div class="col-sm-3">
                        <p>Some text..</p>
                        <img src="logo1.jpg" class="img-responsive" style="width:100%" alt="Image">
                    </div>
                    <div class="col-sm-3">
                        <p>Some text..</p>
                        <img src="logo1.jpg" class="img-responsive" style="width:100%" alt="Image">
                    </div>
                </div>
            </div><br>
            <div class="container-fluid bg-3 text-center">
                <div class="row">
                    <div class="col-sm-3">
                        <p>Some text..</p>
                        <img src="logo1.jpg" class="img-responsive" style="width:100%" alt="Image">
                    </div>
                    <div class="col-sm-3">
                        <p>Some text..</p>
                        <img src="logo1.jpg" class="img-responsive" style="width:100%" alt="Image">
                    </div>
                    <div class="col-sm-3">
                        <p>Some text..</p>
                        <img src="logo1.jpg" class="img-responsive" style="width:100%" alt="Image">
                    </div>
                    <div class="col-sm-3">
                        <p>Some text..</p>
                        <img src="logo1.jpg" class="img-responsive" style="width:100%" alt="Image">
                    </div>
                </div>
            </div>
            <jsp:include page="assets/footer.jsp" />  
        </body>