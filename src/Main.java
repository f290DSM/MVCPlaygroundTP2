import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import model.Contato;
import model.dao.ConexaoFactory;
import model.dao.ContatoMySqlDAO;
import model.repositories.ContatoEmMemoriaRepository;
import model.repositories.ContatoMySqlRepositoryImpl;
import model.repositories.IContatoRepository;

public class Main {

    private static IContatoRepository repository;

    public static void main(String[] args) throws Exception {
        setup(args[0]);

        var c1 = new Contato();
        c1.setNome("Wilson");
        c1.setEmail("wilson@gmail.com");
        c1.setTelefone("(11) 555-5555");

        repository.salvar(c1);
        final List<Contato> contatos = repository.getContatos();

        System.out.println(contatos);
    }

    private static void setup(String arg) throws SQLException {
        configurarBanco();
        if (Objects.isNull(arg) || arg.isEmpty()) {
            repository = new ContatoEmMemoriaRepository();
        } else if (arg.equals("-mysql")){
            Connection conexao = ConexaoFactory.getConexao();
            ContatoMySqlDAO dao = new ContatoMySqlDAO(conexao);
            repository = new ContatoMySqlRepositoryImpl(dao);
        } else {
            repository = new ContatoEmMemoriaRepository();
        }
    }

    private static void configurarBanco() throws SQLException {
        ContatoMySqlDAO dao = new ContatoMySqlDAO(ConexaoFactory.getConexao());
        dao.atualizarTabelas();
    }
}