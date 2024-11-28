/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import model.Avaliacao;
import model.Vestimenta;
import util.VestimentasDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VestimentaDAO {
    private Connection conexao;

    // Método para obter a conexão com o banco de dados
    public Connection getConnection() throws SQLException {
        try {
            if (conexao == null || conexao.isClosed()) {
                // Carregar o driver JDBC (pode variar conforme o banco)
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Estabelecendo a conexão com o banco de dados (ajuste conforme o seu banco)
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/vestimentasdb", "root", "robot");
            }
            return conexao;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver não encontrado!", e);
        }
    }

    // Método para inserir uma pessoa no banco
    public boolean CadastrarVestimenta(Vestimenta vest) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // Obtém a conexão com o banco de dados
            con = getConnection();
            
            // SQL para inserção (ajuste conforme sua tabela)
            String sql = "INSERT INTO vestimentas(tipo, marca, genero, tamanho, preco, quantidade) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            
            // Setando os parâmetros
            ps.setString(1, vest.getTipo());
            ps.setString(2, vest.getMarca());
            ps.setString(3, vest.getGenero());
            ps.setString(4, vest.getTamanho());
            ps.setFloat(5, vest.getPreco());
            ps.setInt(6, vest.getQuantidade());
            
            // Executa o comando de inserção
            int resultado = ps.executeUpdate();
            
            // Retorna true se a inserção foi bem-sucedida
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                // Fechar os recursos
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    

     
   public Vestimenta consultarID(Vestimenta vest) throws ClassNotFoundException{
    //Connectar
        Connection conexao = null;
        try{
            conexao = VestimentasDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from vestimentas where id = '" + vest.getId()+ "'";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            
            int n_reg = 0;
            while (rs.next()) {                 
                vest.setId(Integer.parseInt(rs.getString("id")));  
                vest.setTipo(rs.getString("tipo"));  
                vest.setMarca(rs.getString("marca"));                
                vest.setGenero(rs.getString("genero"));                
                vest.setTamanho(rs.getString("tamanho"));
                vest.setPreco( Float.parseFloat(rs.getString("preco")));                
                vest.setQuantidade(Integer.parseInt(rs.getString("quantidade")));               
                
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return vest;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    } 
   
   public Vestimenta consultarTipo(Vestimenta vest) throws ClassNotFoundException{
    //Connectar
        Connection conexao = null;
        try{
            conexao = VestimentasDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from vestimentas where tipo = '" + vest.getTipo()+ "'";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            
            int n_reg = 0;
            while (rs.next()) {                 
                vest.setId(Integer.parseInt(rs.getString("id")));  
                vest.setTipo(rs.getString("tipo"));  
                vest.setMarca(rs.getString("marca"));                
                vest.setGenero(rs.getString("genero"));                
                vest.setTamanho(rs.getString("tamanho"));
                vest.setPreco( Float.parseFloat(rs.getString("preco")));                
                vest.setQuantidade(Integer.parseInt(rs.getString("quantidade")));                
                
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return vest;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    } 
   
      public List consultaLista() throws ClassNotFoundException{
    //Connectar
        List lista = new ArrayList(); // Minha Lista
        Connection conexao = null;
        try{
            conexao = VestimentasDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from vestimentas";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            
            int n_reg = 0;
            while (rs.next()) {                 
                Vestimenta vest = new Vestimenta();
                vest.setId(Integer.parseInt(rs.getString("id")));  
                vest.setTipo(rs.getString("tipo"));  
                vest.setMarca(rs.getString("marca"));                
                vest.setGenero(rs.getString("genero"));                
                vest.setTamanho(rs.getString("tamanho"));                
                vest.setPreco(Float.parseFloat(rs.getString("preco"))); 
                vest.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                lista.add(vest);
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return lista;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
    
        }
    }  
      
   public boolean AtualizarEstoque(Vestimenta vest) throws ClassNotFoundException {
        //Connectar
        Connection conexao = null;
        try{
            conexao = VestimentasDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                   
            String sql = "UPDATE vestimentas SET tipo='" + vest.getTipo()+ "'" +
                                                    ", marca='" + vest.getMarca()+ "'" +
                                                    ", genero='" + vest.getGenero()+ "'" +
                                                    ", tamanho=" + vest.getTamanho()+ 
                                                    ", preco=" + vest.getPreco()+ 
                                                    ", quantidade=" + vest.getQuantidade()+ 
                                                    "," + " WHERE id = " + vest.getId();
                         
            stmt.executeUpdate(sql); // Executa o SQL: Insert / Delete ou Update
                        
            conexao.close();
            return true;
        }catch(SQLException ex){
            System.out.println(" Exception: " + ex.toString());
            return false;
        }                 
    } 
   
   public boolean BaixaEstoque(Vestimenta vestimenta) throws ClassNotFoundException{
    //Connectar
        Connection conexao = null;
        try{
            conexao = VestimentasDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "DELETE from vestimentas where id = " + vestimenta.getId();
            stmt.executeUpdate(sql);            
            conexao.close();            
            return true;
            
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return false;
        }
    } 
   
   public List ConsultarEstoque() throws ClassNotFoundException{
    //Connectar
        List lista = new ArrayList(); // Minha Lista
        Connection conexao = null;
        try{
            conexao = VestimentasDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from vestimentas";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            
            int n_reg = 0;
            while (rs.next()) {                 
                Vestimenta vestimenta = new Vestimenta();
                vestimenta.setId(Integer.parseInt(rs.getString("id")));  
                vestimenta.setTipo(rs.getString("tipo"));  
                vestimenta.setMarca(rs.getString("marca"));                
                vestimenta.setGenero(rs.getString("genero"));  
                vestimenta.setTamanho(rs.getString("tamanho"));                                
                vestimenta.setPreco (Float.parseFloat(rs.getString("preco")));                
                vestimenta.setQuantidade(Integer.parseInt(rs.getString("quantidade")));                
                lista.add(vestimenta);
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return lista;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    }
   
    public boolean InserirAvaliacao(Avaliacao aval) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // Obtém a conexão com o banco de dados
            con = getConnection();
            
            // SQL para inserção (ajuste conforme sua tabela)
            String sql = "INSERT INTO avaliacoes (nome, q1, q2, q3) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            
            // Setando os parâmetros
            ps.setString(1, aval.getNome());
            ps.setInt(2, aval.getQ1());
            ps.setInt(3, aval.getQ2());
            ps.setInt(4, aval.getQ3());
            
            // Executa o comando de inserção
            int resultado = ps.executeUpdate();
            
            // Retorna true se a inserção foi bem-sucedida
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                // Fechar os recursos
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } 
    
      public List ConsultarAvaliacao() throws ClassNotFoundException{
    //Connectar
        List listaav = new ArrayList(); // Minha Lista
        Connection conexao = null;
        try{
            conexao = VestimentasDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from avaliacoes";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            
            int n_reg = 0;
            while (rs.next()) {                 
                Avaliacao aval = new Avaliacao();
                aval.setId(Integer.parseInt(rs.getString("id")));
                aval.setNome(rs.getString("nome"));
                aval.setQ1(Integer.parseInt(rs.getString("q1"))); 
                aval.setQ2(Integer.parseInt(rs.getString("q2"))); 
                aval.setQ3(Integer.parseInt(rs.getString("q3"))); 
                listaav.add(aval);
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return listaav;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
    
        }
    }    
}
