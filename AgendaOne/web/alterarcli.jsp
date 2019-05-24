<%-- 
    Document   : alterarcli
    Created on : 30/04/2018, 17:04:12
    Author     : user
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Tipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Cliente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Clientes</title>
    </head>
    <h1>Alteração de Cliente</h1>
    <%        //recuperar a lista
        Cliente cliente = (Cliente) request.getAttribute("cliente");
        //recuperar a lista
        ArrayList<Tipo> listaTipo = (ArrayList<Tipo>) request.getAttribute("listaTipo");
    %>
    <body>
        <form action="ControleCliente" method="post">
            Nome:     <input type="text" name="txtNome" value="<%= cliente.getNome()%>"><br>
            CPF:      <input type="text" name="txtCpf" value="<%= cliente.getCpf()%>"><br>
            Telefone: <input type="text" name="txtTelefone" value="<%= cliente.getTelefone()%>"><br>
            Endereço: <input type="text" name="txtEndereco" value="<%= cliente.getEndereco()%>"><br>
            Tipo do cliente:
            <select name="cmbtipocli">
                <%
                    for (Tipo t : listaTipo) {

                        if (cliente.getTipo().getId() == t.getId()) {
                %>

                <option selected=selected value="<%= t.getId()%>"><%= t.getDescricao()%></option>

                <%
                } else {
                %>

                <option  value="<%= t.getId()%>"><%= t.getDescricao()%></option>

                <%
                        }

                    }
                %> 
            </select><br>
            <input type="hidden" name="txtId" value="<%= cliente.getId()%>"/>
            <input type="submit" name="acao" value="Confirmar">
            <input type="submit" name="acao" value="Listar">
        </form>
    </body>
</html>

