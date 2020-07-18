<%-- 
    Document   : alterar_produto
    Created on : 16/04/2019, 19:11:05
    Author     : alunocmc
--%>

<%@page import="modelo.Departamento"%>
<%@page import="modelo.Tipo"%>
<%@page import="modelo.Situacao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%

            Produto objproduto = new Produto();
            objproduto = (Produto) request.getSession().getAttribute("produto"); //aqui pega o objeto produto que esta na sessão

        %>

        <form action="/padraocommand/ControleProduto" method="POST">
            <input type="hidden" name="id" id="id" value="<%= objproduto.getId()%>"/>
            <input type="hidden" name="acao" id="acao" value="Alterar"/>

            <div>
                <label>Descrição</label>
                <input type="text" name="txtdescricao" id="txtdescricao" value="<%= objproduto.getDescricao()%>"/>
            </div>

            <div>
                <label>Quantidade</label>
                <input type="text" name="txtquantidade" id="txtquantidade" value="<%= objproduto.getQuantidade()%>"/>
            </div>
            <!--perceba aque o campo abaixo devera ser uma combo, onde o array list foi disponibilizado na session-->
            <!--porém como se trata de alteração devemos setar qual item será selecionado -->

            <div>
                <label>Departamento</label>
                <select name='cmbdepartamento' onchange="this.form.submit()">
                    <option value="0">Escolha um Departamento</option>
                    <%
                        ArrayList<Departamento> arrdepartamento = new ArrayList<Departamento>();
                        arrdepartamento = (ArrayList<Departamento>) request.getSession().getAttribute("arrdepartamento");
                        String selecionado = "";

                        for (Departamento obj : arrdepartamento) {
                            selecionado = "";
                            if (obj.getId() == objproduto.getDepartamento().getId()) {
                                selecionado = "selected";
                            }

                    %>
                    <option <%= selecionado%> value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <!--perceba aque o campo abaixo devera ser uma combo, onde o array list foi disponibilizado na session-->
            <%
                //neste caso devemos verificar se o array de tipos esta com dados, caso contrário não aparecer o campo
                ArrayList<Tipo> arrtipo = new ArrayList<Tipo>();
                arrtipo = (ArrayList<Tipo>) request.getSession().getAttribute("arrtipo");
                if (arrtipo != null) {
            %>
            <div>
                <label>Tipo</label>
                <select name='cmbtipo'>
                    <%
                        for (Tipo obj : arrtipo) {
                            selecionado= "";
                            if (obj.getId() == objproduto.getTipo().getId()) {
                                selecionado = "selected";
                            }
                    %>
                    <option <%= selecionado %> value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <%
                }
            %>
            <div>
                <label>Situação</label>
                <select name='cmbsituacao'>
                    <%
                        ArrayList<Situacao> arrsituacao = new ArrayList<Situacao>();
                        arrsituacao = (ArrayList<Situacao>) request.getSession().getAttribute("arrsituacao");
                        for (Situacao obj : arrsituacao) {
                            if (obj.getId() == objproduto.getSituacao().getId()) {
                                selecionado = "selected=selected"; //deixa a propriedade selected como selecionada
                            } else {
                                selecionado = ""; //senão deixa vazio
                            }
                    %>
                    <option <%= selecionado%> value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
                </select>
            </div>

            <div>
                <input type="submit" name="btnalterar" id="btnalterar" value="Alterar"/>   
            </div>

        </form>

    </body>
</html>
