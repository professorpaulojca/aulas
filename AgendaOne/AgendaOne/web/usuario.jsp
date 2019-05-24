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
        <link href="css/viewServico.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        <div id="conteudo-DefinicaoServicos">
        <h1>Cadastro de Usuário</h1>
            <form action="ControleUsuario" method="post">
                Nome do Usuário:       <input type="text" name="txtNome"><br>
                CPF do Usuário:        <input type="text" name="txtCpf"><br>
                Telefone do Usuário:   <input type="text" name="txtTelefone"><br>
                Login de acesso:       <input type="text" name="txtLogin"><br>
                Senha de acesso:       <input type="text" name="txtSenha"><br>
                                       <input type="submit" name="acao" value="Cadastrar">
                                       <a href="/AgendaOne/inicio.jsp"><input type="button" value="voltar"></a>
            </form>
        </div>
    </body>
</html>

