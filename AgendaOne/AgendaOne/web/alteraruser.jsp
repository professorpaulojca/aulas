<%-- 
    Document   : alteraruser
    Created on : 04/05/2018, 11:10:39
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AgendaOne</title>
    </head>
    <body>

    <h1>Alteração de Usuário</h1>
    
    <%        //recuperar a lista
        Usuario user = (Usuario) request.getAttribute("user");
    %>
        <form action="ControleUsuario" method="post">
            Nome:     <input type="text" name="txtNome" value="<%= user.getNome()%>"><br>
            CPF:      <input type="text" name="txtCpf" value="<%= user.getCpf()%>"><br>
            Telefone: <input type="text" name="txtTelefone" value="<%= user.getTelefone()%>"><br>
            Login: <input type="text" name="txtLogin" value="<%= user.getLogin()%>"><br>
            Senha: <input type="text" name="txtSenha" value="<%= user.getSenha()%>"><br>
            <input type="hidden" name="txtId" value="<%= user.getId()%>"/>
            <input type="submit" name="acao" value="Confirmar">
        </form>
    </body>
</html>

