<%-- 
    Document   : login
    Created on : 23/05/2018, 15:19:26
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda One</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/jquery.js" type="text/javascript"></script>
        <script src="scripts/placeholder.js" type="text/javascript"></script>
    </head>
    
    <body>
       <div id="conteudo-home">
            <h1>Agenda One</h1>
            <hr>
            <h2 style="color:#333;font-family: verdana">Login de Usuário</h2>
        <form action="ControleUsuario" method="POST">
             
               <input type="text" name="txtUsuario" title="Usuário" class="J_place"/>
               <input type="password" name="txtSenha" title="Senha" class="J_place"/>
               <input type="submit" name="acao" value="Logar">
          
            
        </form>
       </div>
        
    </body>
</html>