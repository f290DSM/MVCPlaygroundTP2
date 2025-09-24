package model.dao;

import model.Contato;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContatoMySqlDAO {
    private final Connection connection;
    private Logger logger;

    public ContatoMySqlDAO(Connection connection) {
        this.connection = connection;
        this.logger = Logger.getLogger(this.getClass().getSimpleName());
    }

    public void salvar(Contato contato) throws SQLException {
        String template = "INSERT INTO fatec.contatos(" +
                "nome, email, telefone)" +
                "VALUES('%s', '%s', '%s');";

        String sql = String.format(template,
                contato.getNome(),
                contato.getEmail(),
                contato.getTelefone());

        try (Statement stm = connection.createStatement()) {
            logger.info(sql);
            stm.execute(sql);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha ao salvar contato.", e);
            throw e;
        }
    }
}
