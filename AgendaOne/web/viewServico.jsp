

<%@page import="modelo.Tipo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda One</title>
    </head>
    <%        //recuperar a lista
        ArrayList<Tipo> listaTipo = (ArrayList<Tipo>) request.getAttribute("listaTipo");
    %>
    
    <body>
        <h1>Definição de Serviços</h1>
     
        <form action="ControleServico" method="post">
            Defina o tipo de Serviço que irá prestar:     <input type="text" name="txtNome"><br>
            Informe o valor referente à esse serviço:      <input type="text" name="txtCpf"><br>
            Qual o tempo em minutos para esse serviço:      <input type="text" name="txtTelefone"><br>
            Tipo do Serviço: <select name="cmbtipoServ">
                <%
                    for (Tipo t : listaTipo) {
                %>
                <option value="<%= t.getId() %>"><%= t.getDescricao() %></option>
                
                <%
                    }
                %>
            </select><br>
            <input type="submit" name="acao" value="Cadastrar">
            <input type="submit" name="acao" value="Listar">
         </form>
    </body>
</html>

