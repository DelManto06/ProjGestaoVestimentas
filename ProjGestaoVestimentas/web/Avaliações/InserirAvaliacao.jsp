<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Avaliacao"%>
<%@page import="modelDAO.VestimentaDAO"%>
<%@page import="java.text.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Estoque</h1>
        <%
            //Entrada
            String nome = request.getParameter("nome");            
            int r1 = Integer.parseInt( request.getParameter("r1") );
            int r2 = Integer.parseInt( request.getParameter("r2") );
            int r3 = Integer.parseInt( request.getParameter("r3") );


            // Instância do objeto e atrib. de dados
            Avaliacao avaliacao= new Avaliacao();
            avaliacao.setNome(nome);
            avaliacao.setQ1(r1);
            avaliacao.setQ2(r2);
            avaliacao.setQ3(r3);      



            
            VestimentaDAO vestDAO = new VestimentaDAO();
            
            if (vestDAO.InserirAvaliacao(avaliacao)){    // Insere e retorna o resultado (true / false).
                //Acesso Permitido
                out.println("Pesquisa inserida com sucesso!!!");
            }else{
                //Acesso Negado
                out.println("Não inserida!!!");
            }          
        %>
    </body>
</html>
