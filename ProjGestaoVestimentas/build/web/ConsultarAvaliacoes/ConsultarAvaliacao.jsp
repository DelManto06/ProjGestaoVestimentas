<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Avaliacao"%>
<%@page import="modelDAO.VestimentaDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%        
            //Select "Lista"
            VestimentaDAO avalDAO = new VestimentaDAO();
            
            List<Avaliacao> listaav = new ArrayList<>();
            listaav = avalDAO.ConsultarAvaliacao();
            
            int reg = 0 ;
            out.println("<br><br> <img src='../imagens/logo.jpg' alt=''/>");
            out.println("<br> <b>Estoque</b>");
            
            out.println("<br><br><b> ID | Nome | Resposta 1 | Resposta 2 | Resposta 3 |"); 
            
            for( int i = 0; i <= listaav.size()-1; i++){            
                out.println(i + " - " + listaav.get(i).getNome() + 
                " - " + listaav.get(i).getQ1() + 
                " - " + listaav.get(i).getQ2() + 
                " - " + listaav.get(i).getQ3()+ "<br>");                                        
                reg++;                           
            }
            out.println("<br><br> <b>Registros: </b>" + reg + "<br>");
           out.println("<br><br> <b> Legenda:</b> <br> <img src='../imagens/escala.jpg' alt=''/>");

        
        %>
    </body>
</html>
