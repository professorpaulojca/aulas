


<%@page import="java.text.DecimalFormat"%>
<%@page import="modelo.Servico"%>
<%@page import="modelo.Cliente"%>
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
        ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) request.getAttribute("listaCliente");
        ArrayList<Servico> listaServico = (ArrayList<Servico>) request.getAttribute("listaServico");
        
    %>
    
    <body>
     <div id="conteudo-DefinicaoServicos">   
         
        <h1>Agendar Apontamento</h1><hr>
     
        <form action="controleAgendamento" method="post">
            
            <span> Cliente: </span> <select name="cmbCliente">
                <%
                    for (Cliente c : listaCliente) {
                %>
                <option value="<%= c.getId() %>"><%= c.getNome() %></option>
                
                <%
                    }
                %>
            </select><br><br>  
            <span> Serviço: </span> <select name="cmbServico">
                <%
                    DecimalFormat df = new DecimalFormat("#,###.00");
                    for (Servico s : listaServico) {
                %>
                <option value="<%= s.getId() %>"><%= s.getNome() %> - Valor = <%= df.format(s.getValor()) %></option>
                
                <%
                    }
                %>
            </select><br><br>
            
            <span> Data Inicial  (dd/mm/aaaa)</span><input type="text" name="txtData"/><br>
            <span> Data Final (dd/mm/aaaa)</span><input type="text" name="txtDatafinal"/><br>
            <span> Hora Inicial(hh:mm:ss)</span><input type="text" name="txtHora"/><br>
            <span> Hora Final (hh:mm:ss)</span><input type="text" name="txtHorafinal"/><br>
            
            <input type="submit" name="acao" value="Confirmar">
            <a href="/AgendaOne/home.jsp"><input type="button" value="voltar"></a>
         </form>
      </div>      
    </body>
</html>

