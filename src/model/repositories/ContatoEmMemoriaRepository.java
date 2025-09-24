package model.repositories;

import model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoEmMemoriaRepository implements IContatoRepository {
    private List<Contato> contatos = new ArrayList<Contato>();

    @Override
    public void salvar(Contato contato) {
        validarContato(contato);
        contatos.add(contato);
    }

    @Override
    public void remover(Contato contato) {
        if (contato == null) {
            throw new RuntimeException("Contato não pode ser nulo.");
        }

        if (!contatos.contains(contato)) {
            throw new RuntimeException("Contato inexistente.");
        }
        contatos.remove(contato);
    }

    @Override
    public List<Contato> getContatos() {
        return contatos;
    }

    @Override
    public Contato buscarContatoPorEmail(String email) {
        for (Contato contato : contatos) {
            if (contato.getEmail().equals(email)) {
                return contato;
            }
        }
        return null;
    }

    @Override
    public Contato atualizar(Contato contato) {
        Contato c = buscarContatoPorEmail(contato.getEmail());
        if (c != null) {
            c.setNome(contato.getNome());
            c.setEmail(contato.getEmail());
            c.setTelefone(contato.getTelefone());
        }
        return c;
    }

    private void validarContato(Contato contato) {

        if (contato == null) {
            throw new RuntimeException("Contato não pode ser nulo.");
        }

        if (contato.getNome() == null || contato.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatorio!");
        }

        if (contato.getEmail() == null || contato.getEmail().isEmpty()) {
            throw new RuntimeException("E-mail é obrigatorio!");
        }

        if (contato.getTelefone() == null || contato.getTelefone().isEmpty()) {
            throw new RuntimeException("Telefone é obrigatorio!");
        }
    }

}
