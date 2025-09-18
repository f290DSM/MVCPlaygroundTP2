package model;

import model.dao.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoRepository {
    private List<Contato> contatos = new ArrayList<Contato>();

    public void salvar(Contato contato) {
        contatos.add(contato);
    }

    public void remover(Contato contato) {
        contatos.remove(contato);
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public Contato buscarContatoPorEmail(String email) {
        for (Contato contato : contatos) {
            if (contato.getEmail().equals(email)) {
                return contato;
            }
        }
        return null;
    }

    public Contato atualizar(Contato contato) {
        Contato c = buscarContatoPorEmail(contato.getEmail());
        if (c != null) {
            c.setNome(contato.getNome());
            c.setEmail(contato.getEmail());
            c.setTelefone(contato.getTelefone());
        }
        return c;
    }

}
