<%-- 
    Document   : listaCliente
    Created on : 30/04/2018, 16:31:47
    Author     : 11162500307
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Agendamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" conten1:="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
    <hl>Lista de Agendamentos</hl>
        <%!
            private ArrayList<Agendamento> listaAgendamento;
        %>
        <%       //recuperar a lista

            listaAgendamento = (ArrayList<Agendamento>) request.getAttribute("listaAgendamentos");


        %>

    <%!
        public String formatahora(int hora) {

            String horastr = "";

            if (hora < 10) {

                horastr = "0" + hora;

            } else {

                horastr = hora + "";
            }

            return horastr;

        }
    %>

    <%!
        public Agendamento mostraHorario(String hora) {

            //caso seja encontrado algum agendamento para o horario o mesmo será mostrado
            //caso contrário seja exibido em branco
            DateFormat fmt = new SimpleDateFormat("HH:mm:ss");
            Agendamento retorno = new Agendamento();
            try {

                Date horacerta = fmt.parse(hora);
                for (Agendamento c : listaAgendamento) {

                    Calendar calini = Calendar.getInstance();
                    calini.setTime(c.getHora());

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(horacerta);

                    Calendar calfinal = Calendar.getInstance();
                    calfinal.setTime(c.getHorafinal());

                    if ((calfinal.get(Calendar.HOUR_OF_DAY) >= cal.get(Calendar.HOUR_OF_DAY)) && (calini.get(Calendar.HOUR_OF_DAY) <= cal.get(Calendar.HOUR_OF_DAY))) {
                        if ((calfinal.get(Calendar.MINUTE) >= cal.get(Calendar.MINUTE)) && (calini.get(Calendar.MINUTE) <= cal.get(Calendar.MINUTE))) {
                           
                            retorno = c;
                            break;

                        } else {

                            retorno.setId(0);

                        }

                    } else {

                        retorno.setId(0);

                    }

                }

            } catch (Exception ex) {

                //
            }

            return retorno;

        }

    %>



    <table border="l">
        <thead>
            <tr>
                <th>Hora</th>
                <th>ID</th>
                <th>Nome</th>
                <th>Telefone</th>            
                <th>Data e Hora</th>
                <th>Tipo de Serviço</th>
                <th>Ferramentas</th>

            </tr>
        </thead>
        <tbody>


            <%                String horareg = "";
                int hora = -1;
                int j = 1;
                for (int i = 0; i <= 95; i++) {
                    if (((i * 15) % 60 == 0)) {
                        j = 0;
                        hora += 1;
                        horareg = formatahora(hora) + ":00";
                    } else {
                        j += 1;
                        horareg = formatahora(hora) + ":" + (j * 15);
                    } %>
            <%

                Agendamento c = mostraHorario(formatahora(hora) + ":" + (j * 15) + ":00");

                if (c.getId() > 0) {
            %>

            <tr>
                <td><%= horareg%></td>
                <td><%= c.getId()%></td>
                <td><%= c.getCliente().getNome()%></td>
                <td><%= c.getCliente().getTelefone()%></td>
                <%
                    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                %>
                <td><%= fmt.format(c.getData()) + " " + c.getHora().toString()%> </td>
                <td><%= c.getServico().getNome()%> </td>
                <td><a href="ControleAgendamento?acao=excluir&id=<%= c.getId()%>"><img src="img/excluir.png" alt=""/></a><a href="ControleAgandamento?acao=alterar&id=<%= c.getId()%>"><img src="img/editar.png" alt=""/></a></td>

            </tr>
            <%
            } else {
            %>

            <tr>
                <td><%= horareg%></td>
                <td></td>
                <td></td>
                <td></td>

                <td> </td>
                <td></td>
                <td></td>

            </tr>
            <%

                    }

                }

            %>

        </tbody>
    </table>
</body>
</html>

