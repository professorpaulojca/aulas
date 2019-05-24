<%-- 
    Document   : listaCliente
    Created on : 30/04/2018, 16:31:47
    Author     : 11162500307
--%>

<%@page import="java.text.DecimalFormat"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/listaAgendamento.css" rel="stylesheet" type="text/css"/>
        <title>AgendaOne</title>
    </head>
    <body>
    <div id="conteudo-ListaAgendamento">    
        <a href="agendamento.jsp"> voltar </a>   
        <h1> Lista de Agendamentos </h1>
            
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

                            if (cal.getTimeInMillis() >= calini.getTimeInMillis() && cal.getTimeInMillis() <= calfinal.getTimeInMillis() ) {

                                    retorno = c;
                                    break;
                                                     

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
                        <th>Valor</th>
                        <th>Excluir</th>

                    </tr>
                </thead>
                <tbody>


                    <%                String horareg = "";
                        int hora = -1;
                        int j = 1;
                        for (int i = 0; i <= 47; i++) {
                            if (((i * 30) % 60 == 0)) {
                                j = 0;
                                hora += 1;
                                horareg = formatahora(hora) + ":00";
                            } else {
                                j += 1;
                                horareg = formatahora(hora) + ":" + (j * 30);
                            } %>
                    <%

                        String minuto="0";
                        minuto = (j * 30) + "";
                        if ((j * 30) < 10) {
                            
                            minuto = "0" + (j * 30);
                        }
                        Agendamento c = mostraHorario(formatahora(hora) + ":" + minuto + ":00");

                        if (c.getId() > 0) {
                    %>

                    <tr>
                        <td><%= horareg%></td>
                        <td><%= c.getId()%></td>
                        <td><%= c.getCliente().getNome()%></td>
                        <td><%= c.getCliente().getTelefone()%></td>
                        <%
                            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                            DecimalFormat df = new DecimalFormat("#,###.00");
                        %>
                        
                        <td><%= fmt.format(c.getData()) + " " + c.getHora().toString()%> </td>
                        <td><%= c.getServico().getNome()%> </td>
                        <td><%= df.format(c.getValor())%> </td>
                        <td><a href="controleAgendamento?acao=excluir&id=<%= c.getId()%>"><img src="img/excluir.png" alt=""/></td>

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
                        <td></td>

                    </tr>
                    <%

                            }

                        }

                    %>

                </tbody>
            </table>
            
   </div>         
</body>
</html>

