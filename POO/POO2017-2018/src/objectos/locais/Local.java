package objectos.locais;

import objectos.pessoas.Pessoa;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class Local implements Serializable {

    private String nome;
    protected Coordenadas coordenadas;
    protected LinkedList<Pessoa> pessoas;

    public Local(String[] args) {
        nome = args[0];
        coordenadas = new Coordenadas(args);
        pessoas = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public void add(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public int getInscricoees() {
        return pessoas.size();
    }

    public boolean isBar() {
        return false;
    }

    public abstract double getReceitas();

    @Override
    public String toString() {
        return " Nome: " + nome + coordenadas.toString() + " Nº Pessoas: " + pessoas.size();
    }
}
