package objectos.pessoas;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable {

    private String curso;

    public Aluno(String[] args) {
        super(args);
        curso = args[3];
    }

    @Override
    public double getDescontoExposicao() {
        return 0.9;
    }

    @Override
    public String toString() {
        return "ALUNO " + super.toString() + " Curso: " + curso;
    }
}
