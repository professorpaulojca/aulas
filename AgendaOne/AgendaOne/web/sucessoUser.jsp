<%-- 
    Document   : sucessoCli
    Created on : 24/05/2018, 11:08:21
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso</title>
    </head>
    <body>
        <strong><font color="blue">O usuário foi <%=request.getAttribute("mensagem")%></font></strong>
         <a href="/AgendaOne/login.jsp">Continuar</a>
    </body>
</html>

