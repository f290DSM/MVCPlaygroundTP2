import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConexaoFactory;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conexao = ConexaoFactory.getConexao();
        
        ResultSet rst = conexao.createStatement()
                .executeQuery("select version() as v;");

        if (rst.next()) {
            System.out.println(rst.getString("v"));
        }

    }
}