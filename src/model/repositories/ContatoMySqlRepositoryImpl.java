package model.repositories;

import model.dao.Contato;

import java.util.List;

public class ContatoMySqlRepositoryImpl implements IContatoRepository {
    @Override
    public void salvar(Contato contato) {

    }

    @Override
    public void remover(Contato contato) {

    }

    @Override
    public List<Contato> getContatos() {
        return List.of();
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
