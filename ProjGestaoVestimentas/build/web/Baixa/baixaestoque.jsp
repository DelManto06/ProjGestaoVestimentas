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
        int id = Integer.parseInt( request.getParameter("id") );
            
        // Instância e atrib de valor
        Vestimenta pesq = new Vestimenta();
        pesq.setId(id);
        
         //Select
        VestimentaDAO vestDAO = new VestimentaDAO();
        if(vestDAO.BaixaEstoque(pesq)){
            out.println("<br> <b>Registro excluído com sucesso!</b> <br>");
        }else{
            out.println("Registro não excluído!!!");
        }

        
        %>
    </body>
</html>
