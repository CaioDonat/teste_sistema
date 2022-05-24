package br.com.senai.dal;
import java.sql.*;
public class ModuloConexao {
    
    //metodo de conexao com base de dados
    public static Connection conector(){
        java.sql.Connection conexao = null;
        
        //declarando variaveis para receber parametros de conexao com o banco
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://10.0.2.4:3306/dbdonat";
        String user = "caiodonat";
        String password = "root";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
