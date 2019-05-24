

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Tipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Servico"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/viewServico.css" rel="stylesheet" type="text/css"/>
        <title>Gestão Servicos</title>
    </head>
    <body>
        <div id="conteudo-DefinicaoServicos">    
            <h1>Alteração de Serviço</h1>
            <%        //recuperar a lista
                Servico servico = (Servico) request.getAttribute("servico");
                //recuperar a lista
                ArrayList<Tipo> listaTipo = (ArrayList<Tipo>) request.getAttribute("listaTipo");
            %>

            <form action="ControleServico" method="post">
                Descrição do Servico:     <input type="text" name="txtNome" value="<%= servico.getNome()%>"><br><br>
                Valor do Serviço:         <input type="text" name="txtValor" value="<%= servico.getValor()%>"><br><br>
                Tempo do Serviço:         <input type="text" name="txtTempo" value="<%= servico.getTempo()%>"><br><br>
                                          <input type="hidden" name="txtSituacao" value="<%= servico.getSituacao()%>">
                Dificuldade:
                <select name="cmbtipoServ">
                    <%
                        for (Tipo t : listaTipo) {

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
        </div>
    </body>
</html>

