<%-- 
    Document   : sucesso
    Created on : 09/03/2018, 19:41:13
    Author     : 11162500307
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso</title>
    </head>
    <body>
        <strong><font color="blue">O serviço foi <%=request.getAttribute("mensagem")%></font></strong>
        <a href="/AgendaOne/ControleServico?acao=InterfaceCadServ">Voltar</a>
    </body>
</html>


