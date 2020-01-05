        package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection getConexao() throws Exception
    {
                    String url = "jdbc:postgresql://localhost:5432/fitcard";
                    String username = "postgres";
                    String password = "92406128";

                    Class.forName("org.postgresql.Driver");
                    Connection conn = DriverManager.getConnection(url, username, password);
                    
                    return conn;
    }
}
