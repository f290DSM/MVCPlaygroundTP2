package model.repositories;

import model.Contato;
import model.dao.ContatoMySqlDAO;

import java.sql.SQLException;
import java.util.List;

public class ContatoMySqlRepositoryImpl implements IContatoRepository {

    final ContatoMySqlDAO dao;

    public ContatoMySqlRepositoryImpl(ContatoMySqlDAO dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(Contato contato) throws Exception {
        dao.salvar(contato);
    }

    @Override
    public void remover(Contato contato) {

    }

    @Override
    public List<Contato> getContatos() {
        return dao.getContatos();
    }

    @Override
    public Contato buscarContatoPorEmail(String email) {
        return null;
    }

    @Override
    public Contato atualizar(Contato contato) {
        return null;
    }
}
