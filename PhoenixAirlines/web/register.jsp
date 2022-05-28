<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/css/register.css" type="text/css">
        <title>Sign Up</title>
    </head>
    <body>
        <h1>Sign Up</h1>
        <form name="register" action="<%=request.getContextPath()%>/RegisterServlet" method="POST">
            <fieldset>
                <legend><span class="number">1</span>Your basic details</legend>
                <label for="name">First Name:</label>
                <input type="text" id="name" name="first_name" value="" placeholder="First Name" required/>
                <label for="number">Last Name:</label>
                <input type="text" id="aadhar" name="last_name" value="" placeholder="Last Name" required/>
                <label for="mail">Email:</label>
                <input type="email" id="mail" name="email" value="" placeholder="Email" required/>
                <label for="number">Username:</label>
                <input type="text" id="username" name="username" value="" placeholder="Username" required/>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" value="" placeholder="Password" required/>
                <label for="password">Re-type Password:</label>
                <input type="password" id="password" name="r_password" value="" placeholder="Re-type Password" required/>
                <label for="tel">Phone number:</label>
                <input type="text" id="ph_no" name="phone" value="" placeholder="Phone number" required/>
                <label for="address">Address:</label>
                <input type="text" id="addr" name="address" value="" placeholder="Address" required/>
                <label for="job">User Role</label>
                <select id="job" name="role">
                    <optgroup label="Choose">
                        <option value="user">User</option>
                        <option value="staffg1">Grade 1 Staff</option>
                        <option value="staffg2">Grade 2 Staff</option>
                        <!--                    <option value="admin">Admin</option>-->
                    </optgroup>
                </select>
                <span style="color:red">
                    <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
                </span>
                <button type="submit" value="Sign Up">Sign Up</button>
            </fieldset>
        </form>
    </body>
</html>