package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    private static final String url = "jdbc:mysql://localhost:3306/fatec";
    private static final String user = "root";
    private static final String password = "segredo";

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
