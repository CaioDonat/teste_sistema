package br.com.farmaciahigia_frenteloja.dal;

import java.sql.*;

/*
 * @author caiodonat
 */
public class ModuloConexao {
    
    SQLException exception; 
    
    public static Connection conector() throws ClassNotFoundException{
        Connection conexao = null;
        
        //declaracao das variaveis para realizar conexao com o banco de dados
        
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/farmacia_higia";
        String user = "frenteloja";
        String password = "root";
        
        try {
            //nao sei porque tem que realizar esse metodo, mas ta ai
            Class.forName(driver);
            
            //realizando a conexao com o banco de dados, atravez do JDBC DriveManeger ().
            //segundo a doc esse metodo de conexao esta sendo utilizado de forma errada.
            //ref doc => MySQL Connector/J 8.0 ~> 7.1 "Connecting to MySQL Using the JDBC DriverManager Interface"
            conexao = DriverManager.getConnection(url, user, password);
            
            //se tudo der certo retorna a conexao
            return conexao;    
            
        } catch (SQLException ex){
            
            //Mostra qual e o erro.
            //**E necessario tratar as exepition para que o usuario possa entender o pq nao esta funcionando.
            //E possivel filtrar a Exception atraves do ErrorCode, relacao de codigo na doc abaixo.
            //ref doc => Oracle Database Contents ~> Error Menssages ~> Using Menssages
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            /*
            SQLState, VendorError, Significado:
            28000, 1045, senha/usuario errada.
            42000, 1044, url errada.
            */
            return null;
        }
    }
}
