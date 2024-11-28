<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vestimenta"%>
<%@page import="modelDAO.VestimentaDAO"%>
<%@page import="java.text.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar</title>
    </head>
    <body>
        <h1>Atualizar Estoque</h1>
        <%
            //Entrada
            int id = Integer.parseInt( request.getParameter("id") );
            String tipo = request.getParameter("tipo");            
            String marca = request.getParameter("marca");
            String genero = request.getParameter("genero");
            String tamanho = ( request.getParameter("tamanho") );
            Float preco = Float.parseFloat( request.getParameter("preco") );
            int quantidade = Integer.parseInt( request.getParameter("quantidade") );
             

            // Instância do objeto e atrib. de dados
            Vestimenta vest = new Vestimenta();
            vest.setId(id);
            vest.setTipo(tipo);
            vest.setMarca(marca);
            vest.setGenero(genero);
            vest.setTamanho(tamanho);
            vest.setPreco(preco);
            vest.setQuantidade(quantidade);
            
            
            VestimentaDAO vestDAO = new VestimentaDAO();
            
            if (vestDAO.AtualizarEstoque(vest)){    
                //Acesso Permitido
                out.println("Pesquisa Alterada com sucesso!!!");
            }else{
                //Acesso Negado
                out.println("Estoque Atualizado!!!");
            }          
        %>
    </body>
</html>
