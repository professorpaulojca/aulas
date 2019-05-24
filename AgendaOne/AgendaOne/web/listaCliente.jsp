<%-- 
    Document   : listaCliente
    Created on : 30/04/2018, 16:31:47
    Author     : 11162500307
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/listaAgendamento.css" rel="stylesheet" type="text/css"/>
        <title>Agenda One</title>
    </head>
<body>
    <div id="conteudo-ListaAgendamento">
    <h1>Lista de Clientes</h1>
    
    <%        //recuperar a lista
        ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) request.getAttribute("listaCliente");
    %>
    <table border="l">
    <thead>
        <tr>
            <th>Nome</th>
            <th>Telefone</th>
            <th>Prioridade</th>
            <th>Ferramentas</th>
            
        </tr>
    </thead>
    <tbody>
    <%
        for(Cliente c :	listaCliente ){
    %>
    <tr>
        <td><%= c.getNome()	%> </td>
        <td><%= c.getTelefone() %> </td>
        <td class="t<%= c.getTipo().getId() %>"> <%= c.getTipo().getDescricao() %> </td>
        
        <td><a href="ControleCliente?acao=excluir&id=<%= c.getId() %>"><img src="img/excluir.png" alt=""/></a><a href="ControleCliente?acao=alterar&id=<%= c.getId() %>"><img src="img/editar.png" alt=""/></a></td>
            
    </tr>
     <%
         
         }
    %>
    </tbody>
        </table>
        <a href="/AgendaOne/ControleCliente?acao=interfaceCADCLI">Voltar</a>
    </div>    
    </body>
</html>

