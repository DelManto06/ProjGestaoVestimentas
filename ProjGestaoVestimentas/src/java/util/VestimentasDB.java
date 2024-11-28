package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VestimentasDB {
    
    // URL do banco de dados, no caso localhost:3306
    private static final String URL = "jdbc:mysql://localhost:3306/vestimentasdb";
    // Nome de usuário do banco de dados
    private static final String USUARIO = "root";
    // Senha do banco de dados
    private static final String SENHA = "robot";
    
    // Método que estabelece a conexão com o banco de dados
    public static Connection conectar() {
        Connection conn = null;
        try {
            // Carregar o driver MySQL JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Estabelece a conexão com o banco de dados
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            
            System.out.println("Conexão bem sucedida!");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conn;
    }

    // Método principal para testar a conexão
    public static void main(String[] args) {
        // Realiza a conexão
        Connection conn = conectar();
        
        // Verifica se a conexão foi bem sucedida
        if (conn != null) {
            try {
                // Fecha a conexão quando não for mais necessária
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}

    

