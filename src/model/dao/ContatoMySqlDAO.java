package model.dao;

import model.Contato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
        String template = "INSERT INTO contatos(" +
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

    public List<Contato> getContatos() throws SQLException {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT id, nome, email, telefone FROM contatos;";

        try (Statement stm = connection.createStatement();
             ResultSet rst = stm.executeQuery(sql)) {
            while(rst.next()) {
                Contato contato = new Contato(
                        rst.getInt("id"),
                        rst.getString("nome"),
                        rst.getString("email"),
                        rst.getString("telefone")
                );
                contatos.add(contato);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha ao recuperar contatos.", e);
        }

        return contatos;
    }
}
