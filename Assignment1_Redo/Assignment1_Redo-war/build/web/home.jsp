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
        <h1>Please input a string to calculate for example : 1+2*2-3+4/2</h1>
        <form method="post" action="Calculate">
            Enter String to calculate: <input type="text" name ="input"><br>
            <input type="submit" value="Calculate">
        </form>
    </body>
</html>
