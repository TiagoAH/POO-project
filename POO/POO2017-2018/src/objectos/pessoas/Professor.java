package objectos.pessoas;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable {

    private String cargo;

    public Professor(String[] args) {
        super(args);
        cargo = args[3];
    }

    @Override
    public String toString() {
        return "PROFESSOR " + super.toString();
    }
}
