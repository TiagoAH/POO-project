package objectos.locais;

import objectos.pessoas.Pessoa;

import java.io.Serializable;
import java.util.LinkedList;

public class Bar extends Local implements Serializable {

    private static double percentagemGest;
    private int lotacao;
    private double consumoMinimo;
    private LinkedList<Pessoa> guestList;

    public Bar(String[] args) {
        super(args);
        lotacao = Integer.parseInt(args[4]);
        consumoMinimo = Double.parseDouble(args[5]);
        guestList = new LinkedList<>();
    }

    public LinkedList<Pessoa> getGuestList() {
        return guestList;
    }

    public static void setPercentagemGest(double percentagemGest) {
        Bar.percentagemGest = percentagemGest;
    }

    @Override
    public void add(Pessoa pessoa) {
        super.add(pessoa);
        if (lotacao * percentagemGest > guestList.size())
            guestList.add(pessoa);
        else if(pessoa.getPerfil().equals("Boémio")) {
            Pessoa p;
            if ((p = getNotBoemio()) != null) {
                guestList.remove(p);
                guestList.add(pessoa);
            }
        }
    }

    public Pessoa getNotBoemio() {
        for (Pessoa pessoa : guestList)
            if (!pessoa.getPerfil().equals("Boémio"))
                return pessoa;
        return null;
    }

    @Override
    public boolean isBar() {
        return true;
    }

    @Override
    public double getReceitas() {
        return pessoas.size() * consumoMinimo;
    }

    @Override
    public String toString() {
        return "BAR " + super.toString() + " Lotação: " + lotacao + " Consumo Mínimo: " + consumoMinimo + " Guest: " + guestList.size();
    }
}
