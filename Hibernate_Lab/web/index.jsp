<%-- 
    Document   : index
    Created on : 23-Mar-2020, 5:42:17 PM
    Author     : CBui
--%>

<%@page import="java.util.List"%>
<%@page import="utility.Author"%>
<%@page import="utility.AuthorHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Author helper!</h1>
        <%  AuthorHelper helper = new AuthorHelper();
            List<Author> list = helper.getAuthorNames();
            for(int i=0; i < list.size();i++)
                out.println(list.get(i).toString() + '\n');
                %>
    </body>
</html>
