package files;

import objectos.Convivio;

import java.io.*;

public class FicheiroObjectos {

    public static Convivio read() {
        Convivio out;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database.ser"));
            out = (Convivio) ois.readObject();
            ois.close();
        } catch (Exception e) {
            new File("database.ser");
            out = FicheiroTexto.read();
            write(out);
        }
        FicheiroTexto.readPercentagemGuest();
        return out;
    }

    public static void write(Convivio convivio) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("database.ser")));
            oos.writeObject(convivio);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
