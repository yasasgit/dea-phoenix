<%-- 
    Document   : staff_user_table
    Created on : May 30, 2022, 7:18:16 PM
    Author     : yasas
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="SearchUsers_sServlet" method="POST">
            <h3>View Users</h3>
            <input type="text" name="search_user" value="" />
            <select name="search_type">
                <option value="email">Email</option>
                <option value="username">Username</option>
            </select>
            <input type="submit" value="View Users" name="view_users" />
        </form>
        <%if ((request.getAttribute("result") != null)) {
                List user_list = new ArrayList();
                user_list = (List) request.getAttribute("result");
                Iterator it = user_list.iterator();%>
        <table border="1">
            <thead>
            </thead>
            <tbody>
                <%while (it.hasNext()) {%>
                <tr>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                    <td><%=it.next()%></td>
                    <td>
                        <input type="submit" value="Block" />
                    </td>
                </tr>
                <%}
                    }%>
            </tbody>
        </table>
    </body>
</html>
