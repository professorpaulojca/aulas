<%-- 
    Document   : sucessoAgendamento
    Created on : 25/05/2018, 11:08:21
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso</title>
    </head>
    <body>
        <strong><font color="blue">Desculpe,  <%=request.getAttribute("mensagem")%></font></strong>
         <a href="/AgendaOne/home.jsp">Continuar</a>
    </body>
</html>

