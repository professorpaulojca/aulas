<%-- 
    Document   : msgcadsucesso
    Created on : 19/02/2019, 21:33:07
    Author     : alunocmc
--%>

<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Cliente objcliente = new Cliente();
        objcliente = (Cliente)request.getSession().getAttribute("cliente");
        %>
    <body>
        <%
            String saudacao;
            if (objcliente.getSexo().getId() == 1) {                
                saudacao = "Seja Bem Vinda! " + objcliente.getNome() + " e o id é" + objcliente.getId();
            } else {                
                saudacao = "Seja Bem Vindo! " + objcliente.getNome()+ " e o id é" + objcliente.getId();
            }
            %>
        <h1><%= saudacao %></h1>
    
    </body>
</html>
