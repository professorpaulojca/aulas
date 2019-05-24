<%-- 
    Document   : menu
    Created on : 23/05/2018, 15:17:01
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda One</title>
    </head>
    <body>
        <%
            HttpSession sessao = request.getSession();
            
            if (sessao.getAttribute("username") == null) {
                
                response.sendRedirect("login.jsp");
            }
        %>
        <h1>Bem Vindo <%=sessao.getAttribute("username")%></h1>

        <p> Menu </p>
        
    </body>
</html>
