

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Tipo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Clientes</title>
    </head>
    <h1>Cadastro de Clientes</h1>
    <%        //recuperar a lista
        ArrayList<Tipo> listaTipo = (ArrayList<Tipo>) request.getAttribute("listaTipo");
    %>
    <body>
        <form action="ControleCliente" method="post">
            Nome:     <input type="text" name="txtNome"><br>
            CPF:      <input type="text" name="txtCpf"><br>
            Telefone: <input type="text" name="txtTelefone"><br>
            Endereço: <input type="text" name="txtEndereco"><br>
            Tipo do cliente: 
            <select name="cmbtipocli">
                <%
                    for (Tipo t : listaTipo) {
                %>
                <option value="<%= t.getId() %>"><%= t.getDescricao() %></option>
              
                <%
                    }
                %> 
            </select><br>
            <input type="submit" name="acao" value="Cadastrar">
            <a href="ControleCliente?acao=Listar">Pesquisa</a>
        </form>
    </body>
</html>

