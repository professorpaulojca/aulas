<%-- 
    Document   : home
    Created on : 09/04/2018, 10:32:54
    Author     : 11162500307
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda One</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            HttpSession sessao = request.getSession();
            
            if (sessao.getAttribute("username") == null) {
                
                response.sendRedirect("login.jsp");
            }
        %>
        <h1>Bem Vindo <%=sessao.getAttribute("username")%></h1>
        <div id="conteudo-home">
            <h1>Agenda One</h1>
            <hr>
            <div id="menu">
                <a href="/AgendaOne/ControleServico?acao=InterfaceCadServ" >Controle de Serviços</a>
                <a href="/AgendaOne/ControleCliente?acao=interfaceCADCLI" >Controle de Clientes</a>
                <a href="/AgendaOne/agendamento.jsp" >Agendamento</a>
            </div><br>
            <img src="/AgendaOne/img/Agenda1.png"/>
        </div>
    </body>
</html>

