<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vestimenta"%>
<%@page import="modelDAO.VestimentaDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        //Entrada/Receber
        int id = Integer.parseInt(request.getParameter("id"));
            
        // Instância e atrib de valor
        Vestimenta vest = new Vestimenta();
        vest.setId(id);
        
         //Select
        VestimentaDAO vestDAO = new VestimentaDAO();
        if(vestDAO.consultarID(vest) != null){
                out.println("<br> <b>Pesquisa de Estoque</b> <br>");
                out.println("<br> Tipo: " + vest.getTipo());
                out.println("<br> Marca: " + vest.getMarca());
                out.println("<br> Genero: " + vest.getGenero());
                out.println("<br> Tamanho: " + vest.getTamanho());
                out.println("<br> Preço: " + vest.getPreco());                                                       
                out.println("<br> Quantidade: " + vest.getQuantidade());                                                       
        }else{
               out.println("Registro não encontrado!!!");
        }

        
        %>
    </body>
</html>
