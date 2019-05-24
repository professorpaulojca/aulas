<%-- 
    Document   : listaServico
    Created on : 09/03/2018, 19:41:47
    Author     : 11162500307
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Servico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/listaAgendamento.css" rel="stylesheet" type="text/css"/>
        <title>Agenda One</title>
    </head>
<body>
    <div id="conteudo-ListaAgendamento">
    <h1>Lista de Serviços</h1>
    
    <%        //recuperar a lista
        ArrayList<Servico> listaServico = (ArrayList<Servico>) request.getAttribute("listaServico");
    %>
    <table border="l">
    <thead>
        <tr>
            <th>Servico</th>
            <th>Valor</th>
            <th>Tempo</th>
            <th>Dificuldade</th>
            <th>Ferramentas</th>
            
        </tr>
    </thead>
    <tbody>
    <%
        DecimalFormat df = new DecimalFormat("#,###.00");
        for(Servico c :	listaServico ){
    %>
    <tr>
        <td><%= c.getNome() %></td>
        <td><%= df.format(c.getValor())%> </td>
        <td><%= df.format(c.getTempo())%> </td>
        <td class="t<%= c.getTipo().getId() %>"> <%= c.getTipo().getDescricao() %> </td>
        <td><a href="ControleServico?acao=excluir&id=<%= c.getId() %>"><img src="img/excluir.png" alt=""/></a><a href="ControleServico?acao=alterar&id=<%= c.getId() %>"><img src="img/editar.png" alt=""/></a></td>
           
    </tr>
     <%
         }
    %>
    </tbody>
        </table>
    <a href="/AgendaOne/ControleServico?acao=InterfaceCadServ">Voltar</a> 
    </div>
    </body>
</html>


