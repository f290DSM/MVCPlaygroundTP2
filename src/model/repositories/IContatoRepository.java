package model.repositories;

import model.Contato;

import java.util.List;

public interface IContatoRepository {
    void salvar(Contato contato) throws Exception;

    void remover(Contato contato);

    List<Contato> getContatos();

    Contato buscarContatoPorEmail(String email);

    Contato atualizar(Contato contato);
}
