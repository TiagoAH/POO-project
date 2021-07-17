package objectos.pessoas;

import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable {

    private String tempo;

    public Funcionario(String[] args) {
        super(args);
        tempo = args[3];
    }

    @Override
    public String toString() {
        return "FUNCIONARIO " + super.toString();
    }
}
