<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vestimenta"%>
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
            VestimentaDAO vestDAO = new VestimentaDAO();
            
            List<Vestimenta> lista = new ArrayList<>();
            lista = vestDAO.ConsultarEstoque();
            
            int n_reg = 0 ;
            out.println("<br> <b>Estoque</b>");
            
            out.println("<br><br><b> ID | Tipo | Marca | Genêro | Tamanho | Preço | Quantidade </b> <br>"); 
            
            for( int i = 0; i <= lista.size()-1; i++){            
                out.println(i + " - " + lista.get(i).getTipo() + " - " + lista.get(i).getMarca() + " - " 
                + lista.get(i).getGenero() + 
                " - " + lista.get(i).getTamanho()+ " - " + lista.get(i).getPreco()+
                " - " + lista.get(i).getQuantidade()   +"<br>");                                        
                n_reg++;                           
            }
            out.println("<br><br> <b>Registros: </b>" + n_reg + "<br>");


        
        %>
    </body>
</html>
