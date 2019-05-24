

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Tipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Servico"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Servicos</title>
    </head>
    <body>
    <h1>Alteração de Serviço</h1>
     <%        //recuperar a lista
        Servico servico = (Servico) request.getAttribute("servico");
        //recuperar a lista
        ArrayList<Tipo> listaTipo = (ArrayList<Tipo>) request.getAttribute("listaTipo");
    %>
    
         <form action="ControleServico" method="post">
            Servico:     <input type="text" name="txtNome" value="<%= servico.getNome() %>"><br><br>
            Valor:      <input type="text" name="txtCpf" value="<%= servico.getCpf()%>"><br><br>
            Tempo: <input type="text" name="txtTelefone" value="<%= servico.getTelefone()%>"><br><br>
            <input type="hidden" name="txtSituacao" value="<%= servico.getSituacao()%>">
            Dificuldade:
            <select name="cmbtipoServ">
                <%
                    for (Tipo t : listaTipo) 
                    {

                        if (servico.getTipo().getId() == t.getId()) {
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
            
            <input type="hidden" name="txtId" value="<%= servico.getId()%>"/><br>
            <input type="submit" name="acao" value="Confirmar">
            <input type="submit" name="acao" value="Listar">
         </form>
    </body>
</html>

