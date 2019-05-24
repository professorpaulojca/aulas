<%-- 
    Document   : agendamento
    Created on : 14/05/2018, 17:29:23
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/agendamento.css" rel="stylesheet" type="text/css"/>
        <title>AgendaOne</title>
    </head>
    <body>
        <div id="conteudo-agendamento">
            <a href="home.jsp"> voltar </a>
        <h1>Agendamento</h1>
        <form action="controleAgendamento" method="POST">
            
              <label>Digite a Data  (dd/mm/aaaa)</label>
        
        <input type="text" name="txtdata"/>
        
        <div>
            <input type="submit" name="acao" value="Listar"/>
            <input type="submit" name="acao" value="Agendar"/>
            
        </div>
        </form>
        </div>    
        
    </body>
</html>
