package objectos.locais;

import objectos.pessoas.Pessoa;

import java.io.Serializable;

public class Exposicao extends Local implements Serializable {

    private String formaArtistica;
    private double custoIngresso;

    public Exposicao(String[] args) {
        super(args);
        formaArtistica = args[4];
        custoIngresso = Double.parseDouble(args[5]);
    }

    @Override
    public double getReceitas() {
        double receitas = 0;
        for (Pessoa pessoa : pessoas)
            receitas += custoIngresso * pessoa.getDescontoExposicao();
        return receitas;
    }

    @Override
    public String toString() {
        return "EXPOSIÇÃO " + super.toString() + " Forma Artística: " + formaArtistica + " Custo Ingresso: " + custoIngresso;
    }
}
