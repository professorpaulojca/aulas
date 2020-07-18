<%-- 
    Document   : alterar_situacao
    Created on : 16/04/2019, 19:11:05
    Author     : alunocmc
--%>

<%@page import="modelo.Tipo"%>
<%@page import="modelo.Departamento"%>
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


        <form action="/padraocommand/ControleProduto" method="POST">

            <input type="hidden" name="acao" id="acao" value="Cadastrar"/>
            <%
                String descricaoviewstate = "";
                String quantidadeviewstate = "";
                String departamentoviewstate = "0";
                String situacaoviewstate = "1";
                try {
                    if (request.getSession().getAttribute("descricaoviewstate") != null) {
                        descricaoviewstate = (String) request.getSession().getAttribute("descricaoviewstate");
                        quantidadeviewstate = (String) request.getSession().getAttribute("quantidadeviewstate");
                        departamentoviewstate = (String) request.getSession().getAttribute("departamentoviewstate");
                        situacaoviewstate = (String) request.getSession().getAttribute("situacaoviewstate");
                    }

                } catch (Exception ex) {
                    //
                }


            %>
            <div>
                <label>Descrição</label>
                <input type="text" name="txtdescricao" id="txtdescricao" value="<%= descricaoviewstate%>"/>
            </div>
            <div>
                <label>Quantidade</label>
                <input type="text" name="txtquantidade" id="txtquantidade" value="<%= quantidadeviewstate%>"/>
            </div>
            <!--perceba aque o campo abaixo devera ser uma combo, onde o array list foi disponibilizado na session-->
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
                            if (obj.getId() == Integer.parseInt(departamentoviewstate)) {
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
                    %>
                    <option value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <%
                }
            %>
            <!--perceba aque o campo abaixo devera ser uma combo, onde o array list foi disponibilizado na session-->
            <div>
                <label>Situação</label>
                <select name='cmbsituacao'>
                    <%
                        ArrayList<Situacao> arrsituacao = new ArrayList<Situacao>();
                        arrsituacao = (ArrayList<Situacao>) request.getSession().getAttribute("arrsituacao");

                        for (Situacao obj : arrsituacao) {
                            selecionado = "";
                            if (obj.getId() == Integer.parseInt(situacaoviewstate)) {
                                selecionado = "selected";
                            }
                    %>
                    <option value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
                </select>
            </div>

            <div>
                <input type="submit" name="btncadastrar" id="btncadastrar" value="Cadastrar"/>   
            </div>

        </form>

    </body>
</html>
