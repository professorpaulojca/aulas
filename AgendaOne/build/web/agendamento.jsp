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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agendamento</h1>
        <form action="controleAgendamento" method="POST">
            
              <label>Digite a Data</label>
        
        <input type="text" name="txtdata"/>
        
        <div>
            <input type="submit" name="acao" value="Listar"/>
        </div>
        </form>
      
        
    </body>
</html>
