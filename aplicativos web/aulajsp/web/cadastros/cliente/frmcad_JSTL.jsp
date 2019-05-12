<%-- 
    Document   : frmcad
    Created on : 19/02/2019, 19:51:21
    Author     : alunocmc
--%>

<%@page import="modelo.Estado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Cidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>
    <body>

        <form action="/aulajsp/${controller}" method="POST">

            <div>
                <label>Nome: </label><input type="text" name="txtnome" id="txtnome" />
            </div>
            <div>
                <label>Sexo: </label>
                <select name="cmbsexo" id="cmbsexo">
                    <option value="1">Feminino</option>  
                    <option value="2">Masculino</option>     
                </select>
            </div>
            <div>
                <label>Estado: </label>
                <select name="cmbestado" id="cmbestado" onchange="form.submit();">
                    <option value="0" selected="selected" >Selecione um Estado</option>
                    <c:forEach var="obj" items="${arrestados}">
                        <c:if test="${estadoselecionado == obj.id}">
                            <option selected="selected" value="${obj.id}">${obj.descricao}</option>
                        </c:if>
                        <c:if test="${estadoselecionado != obj.id}">
                            <option  value="${obj.id}">${obj.descricao}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <c:if test="${objestado != null}">
                <div>
                    <label>Cidade: </label>
                    <select name="cmbcidade" id="cmbcidade">
                        <c:forEach var="obj" items="${objestado.arracidades}">
                            <option  value="${obj.id}">${obj.nome}</option>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    <input type="submit" name="btngravar" id="btngravar" value="Gravar"/>
                </div>
            </c:if>

        </form>

    </body>
</html>
