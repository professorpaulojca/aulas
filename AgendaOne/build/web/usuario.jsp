<%-- 
    Document   : usuario
    Created on : 04/05/2018, 10:09:28
    Author     : user
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AgendaOne</title>
    </head>
    
    <body>
    <h1>Cadastro de Usuário</h1>
    
        <form action="ControleUsuario" method="post">
            Nome:       <input type="text" name="txtNome"><br>
            CPF:        <input type="text" name="txtCpf"><br>
            Telefone:   <input type="text" name="txtTelefone"><br>
            Login:      <input type="text" name="txtLogin"><br>
            Senha:      <input type="text" name="txtSenha"><br>
                        <input type="submit" name="acao" value="Cadastrar">
            
            <a href="ControleCliente?acao=Listar">Voltar</a>
        </form>
    </body>
</html>

