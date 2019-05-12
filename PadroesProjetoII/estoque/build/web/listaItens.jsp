<%-- 
    Document   : listaCliente
    Created on : 09/03/2018, 19:41:47
    Author     : 11162500606
--%>

<%@page import="java.util.Calendar"%>
<%@page import="modelo.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" conten1:="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%        //
            Pedido pedido = (Pedido) request.getAttribute("pedido");
            Calendar cal = Calendar.getInstance();
            cal.setTime(pedido.getData());

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(pedido.getHora());


        %>

    <hl>Lista de Itens </hl>
        <%        //recuperar a lista
            ArrayList<Item> listaItem = pedido.getItens();
        %>
    <table border="l">
        <thead>
            <tr>
                <th>Pedido nº</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Produto</th>
                <th>Foto</th>
                <th>Ferramentas</th>

            </tr>
        </thead>
        <tbody>
            <%
                for (Item c : listaItem) {
            %>
            <tr>
                <td><%= pedido.getId()%></td>
                <td><%= cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR)%> </td>
                <td><%= cal2.get(Calendar.HOUR_OF_DAY) + ":" + cal2.get(Calendar.MINUTE) + ":" + cal2.get(Calendar.SECOND)%> </td>
                <td><%= c.getProduto().getNome()%> </td>
                <td><img src="img/<%= c.getProduto().getFoto()%>" width="50"/> </td>

                <td><a href="controlemovimento?iditem=<%= c.getId() %>&idpedido=<%= pedido.getId() %>"><img src="img/baixar.png" width="50" alt=""/></a></td>

            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>

