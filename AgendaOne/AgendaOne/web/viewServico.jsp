

<%@page import="modelo.Tipo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda One</title>
        <link href="css/viewServico.css" rel="stylesheet" type="text/css"/>
    </head>
    <%        //recuperar a lista
        ArrayList<Tipo> listaTipo = (ArrayList<Tipo>) request.getAttribute("listaTipo");
    %>
    
    <body>
     <div id="conteudo-DefinicaoServicos">  
        <h1>Definição de Serviços</h1><hr>
     
        <form action="ControleServico" method="post">
            <span>Defina o tipo de Serviço que irá prestar:</span>     <input type="text" name="txtNome"><br>
            <span> Informe o valor referente à esse serviço: </span>     <input type="text" name="txtValor"><br>
            <span> Qual o tempo em minutos para esse serviço:</span>      <input type="text" name="txtTempo"><br>
            <span> Dificuldade: </span> <select name="cmbtipoServ">
                <%
                    for (Tipo t : listaTipo) {
                %>
                <option value="<%= t.getId() %>"><%= t.getDescricao() %></option>
                
                <%
                    }
                %>
            </select><br>
            <input type="submit" name="acao" value="Cadastrar">
            <input type="submit" name="acao" value="Listar">
            <a href="/AgendaOne/home.jsp"><input type="button" value="Voltar"></a>
            <br>
            
         </form>
      </div>      
    </body>
</html>

