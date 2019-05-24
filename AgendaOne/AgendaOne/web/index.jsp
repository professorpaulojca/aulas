

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Tipo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Clientes</title>
        <link href="css/viewServico.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    
    <%        //recuperar a lista
        ArrayList<Tipo> listaTipo = (ArrayList<Tipo>) request.getAttribute("listaTipo");
    %>
    <div id="conteudo-DefinicaoServicos">
        <h1>Cadastro de Clientes</h1>
        <form action="ControleCliente" method="post">
            Nome do Cliente:     <input type="text" name="txtNome"><br>
            CPF do Cliente:      <input type="text" name="txtCpf"><br>
            Telefone: <input type="text" name="txtTelefone"><br>
            Endereço: <input type="text" name="txtEndereco"><br>
            Prioridade: 
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
            <a href="ControleCliente?acao=Listar"><input type="button" value="Pesquisa"></a>
            <a href="/AgendaOne/home.jsp"><input type="button" value="voltar"></a>
        </form>
    </div>    
    </body>
</html>

