package objectos;

import objectos.locais.Local;
import objectos.pessoas.Pessoa;

import java.io.Serializable;
import java.util.LinkedList;

public class Convivio implements Serializable {

    private LinkedList<Pessoa> pessoas;
    private LinkedList<Local> locais;

    public Convivio() {
        pessoas = new LinkedList<>();
        locais = new LinkedList<>();
    }

    public void add(Local local) {
        locais.add(local);
    }

    public void add(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public Pessoa login(String username, String password) throws Exception {
        for(Pessoa pessoa : pessoas)
            if (pessoa.login(username, password))
                return pessoa;
        throw new Exception("Username e Password não\ncorrespondem a nenhuma pessoa\nna nossa base de dados!");
    }

    public LinkedList<Pessoa> getPessoas() {
        return pessoas;
    }

    public LinkedList<Local> getLocais() {
        return locais;
    }
}
