<%-- 
    Document   : buyTrip
    Created on : 5 mars 2014, 16:13:04
    Author     : acuvillier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST">
            <input type="hidden" name="tripid" value="${tripid}" />
            <label for="firstname">First Name :</label>
            <input type="text" name="firstname" />
            <br>
            <label for="lastname">Last Name :</label>
            <input type="text" name="lastname" />
            <br>
            <label for="email">E-mail :</label>
            <input type="text" name="email" />
            <br>
            <input type="submit" value="Process order" />
        </form>
    </body>
</html>
