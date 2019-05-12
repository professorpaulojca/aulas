<%-- 
    Document   : alterar_tipo
    Created on : 16/04/2019, 19:11:05
    Author     : alunocmc
--%>

<%@page import="java.net.URLEncoder"%>
<%@page import="modelo.Tipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utilidades.AES"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%

            Tipo objtipo = new Tipo();
            objtipo = (Tipo) request.getSession().getAttribute("tipo"); //aqui pega o objeto tipo que esta na sessão

        %>

        <form action="/padraocommandAES/ControleTipo" method="POST">
            <input type="hidden" name="id" id="id" value="<%= objtipo.getIdcrypt()%>"/>
            <input type="hidden" name="acao" id="acao" value="<%= URLEncoder.encode(AES.encrypt("Alterar"),"UTF-8") %>"/>

            <div>
                <label>Descrição</label>
                <input type="text" name="descricao" id="descricao" value="<%= objtipo.getDescricao()%>"/>
            </div>

            <div>
                <input type="submit" name="btnalterar" id="btnalterar" value="Alterar"/>   
            </div>

        </form>

    </body>
</html>
