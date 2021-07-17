package objectos.locais;

import java.io.Serializable;

public class AreaDesportiva extends Parque implements Serializable {

    private String[] desportos;

    public AreaDesportiva(String[] args) {
        super(args);
        desportos = args[4].split(",");
    }

    @Override
    public String toString() {
        return "AREADESPORTIVA " + super.toString() + " Area Desportisva: " + desportos;
    }
}
