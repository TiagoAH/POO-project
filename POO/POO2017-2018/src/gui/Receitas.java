package gui;

import objectos.Convivio;
import objectos.locais.Local;

import javax.swing.*;
import java.awt.*;

public class Receitas extends GUIObject {

    public Receitas(Convivio convivio) {
        super(new GridLayout(1, 0), convivio, "RECEITAS");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        double total = 0;

        JTextArea receitas = new JTextArea();

        for (Local local : convivio.getLocais()) {
            receitas.append(local.toString() + "\nReceitas: " + local.getReceitas() + "\n");
            total+=local.getReceitas();
        }

        receitas.append("Total Receitas: " + total);

        add(receitas);
        add(sair);

        runScrollPane();
    }
}
