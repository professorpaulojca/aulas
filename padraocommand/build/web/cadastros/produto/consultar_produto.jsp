<%-- 
    Document   : alterar_produto
    Created on : 16/04/2019, 19:11:05
    Author     : alunocmc
--%>

<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%

            Produto objproduto = new Produto();
            objproduto = (Produto) request.getSession().getAttribute("produto"); //aqui pega o objeto produto que esta na sessão

        %>

        <form>
          
            <div>
                <label>Descrição</label>
                <lable><b><%= objproduto.getDescricao()%></b></lable>
            </div>    
            
             <div>
                <label>Quantidade</label>
                <lable><b><%= objproduto.getQuantidade()%></b></lable>
            </div>    
            
            <div>
                <label>Situacao</label>
                <lable><b><%= objproduto.getSituacao().getDescricao() %></b></lable>
            </div>    

        </form>

    </body>
</html>
