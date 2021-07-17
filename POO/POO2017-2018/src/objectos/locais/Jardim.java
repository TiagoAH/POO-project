package objectos.locais;

import java.io.Serializable;

public class Jardim extends Parque implements Serializable {

    private double area;

    public Jardim(String[] args) {
        super(args);
        area = Double.parseDouble(args[4]);
    }

    @Override
    public String toString() {
        return "JARDIM " + super.toString() + " Área: " + area;
    }
}
