<%-- 
    Document   : frmcad
    Created on : 19/02/2019, 19:51:21
    Author     : alunocmc
--%>

<%@page import="modelo.Estado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Cidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>
    <body>

        <form action="/aulajsp/<%= request.getSession().getAttribute("controller").toString() %> " method="POST">

            <div>
                <label>Nome: </label><input type="text" name="txtnome" id="txtnome" />
            </div>
            <div>
                <label>Sexo: </label>
                <select name="cmbsexo" id="cmbsexo">
                    <option value="1">Feminino</option>  
                    <option value="2">Masculino</option>     
                </select>
            </div>
            <div>
                <label>Estado: </label>
                <select name="cmbestado" id="cmbestado" onchange="form.submit();">
                    <option value="0">Selecione um Estado</option>
                    <%
                        int erro = 0;
                        try {

                            //verifica se o estado já está na sessão
                            int estadoselecionado = 0;
                            try {

                                estadoselecionado = Integer.parseInt(request.getSession().getAttribute("estadoselecionado").toString());

                            } catch (Exception ex) {

                                estadoselecionado = 0;
                            }

                            ArrayList<Estado> arrestados = new ArrayList<Estado>();
                            arrestados = (ArrayList<Estado>) request.getSession().getAttribute("arrestados");
                            for (Estado obj : arrestados) {

                                if (estadoselecionado == obj.getId()) {
                    %>
                    <option selected="selected" value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <% } else {%>

                    <option value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                            }
                        }
                    } catch (Exception ex) {
                        erro = 1;
                    %>
                    <script>
                        alert("Falta cadastrar os estados!");
                    </script>

                    <%
                        }

                    %>
                </select>
            </div>
            <div>

                <%  //soh vai fazer o código abaixo se o estado já estiver selecionado                      
                    try {
                        ArrayList<Cidade> arrcidades = new ArrayList<Cidade>();
                        Estado estado = new Estado();
                        estado = (Estado) request.getSession().getAttribute("objestado");

                        arrcidades = estado.getArracidades();
                        
                        if (arrcidades != null) {
                %>
                <label>Cidade: </label>
                <select name="cmbcidade" id="cmbcidade">     
                    <%                        for (Cidade obj : arrcidades) {
                    %>                            
                    <option value="<%= obj.getId()%>"><%= obj.getNome()%></option>                            
                    <%
                        }
                    %>
                </select>
                <%
                        } else {
                            erro = 1;
                        }
                    } catch (Exception ex) {
                        erro = 1;

                    }
                %>

            </div>
            <% if (erro == 0) { %>

            <div>
                <input type="submit" name="btngravar" id="btngravar" value="Gravar"/>
            </div>

            <%}%>


        </form>

    </body>
</html>
