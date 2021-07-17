package objectos.locais;

import java.io.Serializable;

public abstract class Parque extends Local implements Serializable {

    public Parque(String[] args) {
        super(args);
    }

    @Override
    public double getReceitas() {
        return 0;
    }
}
