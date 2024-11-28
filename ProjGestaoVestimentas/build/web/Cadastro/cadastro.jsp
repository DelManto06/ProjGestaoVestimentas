<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vestimenta"%>
<%@page import="modelDAO.VestimentaDAO"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="java.lang.*"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
    try {
        // Obtendo parâmetros da requisição
        String tipo = request.getParameter("tipo");
        String marca = request.getParameter("marca");
        String genero = request.getParameter("genero");
        String tamanho = request.getParameter("tamanho");
        float preco = Float.parseFloat(request.getParameter("preco"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        // Instanciando o objeto Pessoa e atribuindo os dados
        Vestimenta vest= new Vestimenta();
        vest.setTipo(tipo);
        vest.setMarca(marca);
        vest.setGenero(genero);
        vest.setTamanho(tamanho);
        vest.setPreco(preco);
        vest.setQuantidade(quantidade);

        // Instanciando o objeto PessoaDAO
        VestimentaDAO vestDAO = new VestimentaDAO();

        // Inserindo a pessoa no banco e exibindo o resultado
        if (vestDAO.CadastrarVestimenta(vest)) {
            out.println("Registro inserido com sucesso!");
        } else {
            out.println("Erro! Registro não inserido!!!");
        }
    } catch (Exception e) {
        // Exibe a mensagem de erro e o stack trace no console do servidor
        out.println("Ocorreu um erro: " + e.getMessage());
        e.printStackTrace();  // Imprime o stack trace no console do servidor (logs)
    }
%>
</body>
</html>


