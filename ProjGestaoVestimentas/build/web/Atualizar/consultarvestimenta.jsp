<%-- 
    Document   : consultaReg
    Created on : 30 de out. de 2024, 21:25:47
    Author     : alunocmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vestimenta"%>
<%@page import="modelDAO.VestimentaDAO"%>
<%@page import="java.text.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar (Consulta)</title>
    </head>
    <body>
        <%
        //Entrada/Receber
        int id = Integer.parseInt( request.getParameter("id") );
            
        // Instância e atrib de valor
        Vestimenta vest = new Vestimenta();
        vest.setId(id);
        
         //Select
        VestimentaDAO vestDAO = new VestimentaDAO();
        if(vestDAO.consultarID(vest) != null){
                out.println("<h2>Pesquisa de Estoque</h2> <br>");
        %>                          
        <form name="frmPesq" method="post" action="atualizar.jsp">
            Identificador: <input type="text" name="id" value="<%= vest.getId()%>" > <p>
            Tipo: <input type="text" name="tipo" value="<%= vest.getTipo() %>" > <p>
            Marca: <input type="text" name="marca" value="<%= vest.getMarca()%>"> <p>                
            Genero: <input type="text" name="genero" value="<%= vest.getGenero()%>"> <p>                
            Tamanho: <input type="text" name="tamanho" value="<%= vest.getTamanho()%>"> <p>                
            Preço: <input type="text" name="preco" value="<%= vest.getPreco()%>"> <p>                
            Quantidade: <input type="text" name="quantidade" value="<%= vest.getQuantidade()%>"> <p>                
            <input type="submit" value="Salvar">
        </form>                 
        <%        
                out.println("<br><br> <b> Legenda:</b> <br> <img src='../imagens/escala.jpg' alt=''/>");                             
        }else{
               out.println("Registro não encontrado!!!");
        }        
        %>
    </body>
</html>
