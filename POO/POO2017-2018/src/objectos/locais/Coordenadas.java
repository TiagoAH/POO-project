package objectos.locais;

import java.io.Serializable;

public class Coordenadas implements Serializable {

    private double latitude;
    private double longitude;
    private double altura;

    public Coordenadas(String[] args) {
        latitude = Double.parseDouble(args[1]);
        longitude = Double.parseDouble(args[2]);
        altura = Double.parseDouble(args[3]);
    }

    @Override
    public String toString() {
        return " x: " + latitude + " y: " + longitude + " z:" + altura;
    }
}
