import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.ConexaoFactory;
import model.dao.ContatoMySqlDAO;

public class Main {
    public static void main(String[] args) throws SQLException {
        configurarBanco();
    }

    private static void configurarBanco() throws SQLException {
        ContatoMySqlDAO dao = new ContatoMySqlDAO(ConexaoFactory.getConexao());
        dao.atualizarTabelas();
    }
}