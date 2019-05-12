<%-- 
    Document   : lista_tipo
    Created on : 15/04/2019, 19:56:06
    Author     : alunocmc
--%>

<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Tipo"%>
<%@page import="utilidades.AES"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo</title>
    </head>
    <body>
        <h1>Lista de Tipos</h1>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Descrição</th>
                    <th>Operações</th>
                </tr>
            </thead>
            <tbody>
            <%
                ArrayList<Tipo> arrtipo = new ArrayList<Tipo>();
                arrtipo = (ArrayList<Tipo>) request.getSession().getAttribute("arrtipo");
                for (Tipo obj : arrtipo) {
            %>
             <tr>
                    <td> <%= obj.getId()%></td>
                    <td> <%= obj.getDescricao()%></td>
                    <td><a href="ControleTipo?acao=<%= URLEncoder.encode(AES.encrypt("Buscar"),"UTF-8") %>&id=<%= URLEncoder.encode(obj.getIdcrypt(),"UTF-8")%>">Alterar</a></td>
                </tr>
           
            
                <%
                }
            %>
            </tbody>
        </table>
    </body>
</html>
