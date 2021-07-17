package objectos.pessoas;

import objectos.locais.Local;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class Pessoa implements Serializable {

    protected String perfil;
    protected String username;
    protected String password;
    protected LinkedList<Local> locais;

    public Pessoa(String[] args) {
        perfil = args[0];
        username = args[1];
        password = args[2];
        locais = new LinkedList<>();
    }

    public String getPerfil() {
        return perfil;
    }

    public String getUsername() {
        return username;
    }

    public LinkedList<Local> getLocais() {
        return locais;
    }

    public void add(Local local) {
        locais.add(local);
        local.add(this);
    }

    public boolean login(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }

    public double getDescontoExposicao() {
        return 1;
    }

    @Override
    public String toString() {
        return "Perfil: " + perfil + " Nome: " + username;
    }
}
