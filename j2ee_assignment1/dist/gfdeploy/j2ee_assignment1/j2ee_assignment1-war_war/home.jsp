<%-- 
    Document   : home
    Created on : 1-Mar-2020, 9:23:32 AM
    Author     : CBui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please input a and b then select your function to calculate</h1>
        <form method="post" action="Calculate">
            Enter a: <input type="text" name ="a"><br>
            Enter b: <input type="text" name ="b"><br><br>
            <input type="submit" name="action" value="Add">
            <input type="submit" name="action" value="Subtract">
            <input type="submit" name="action" value="Multiply">
        </form>
    </body>
</html>
