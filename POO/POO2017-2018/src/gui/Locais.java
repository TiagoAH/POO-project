package gui;

import objectos.Convivio;
import objectos.locais.Local;
import objectos.pessoas.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class Locais extends GUIObject {

    private class Comparator implements java.util.Comparator<Local> {
        @Override
        public int compare(Local l1, Local l2) {
            if (l1.getInscricoees() < l2.getInscricoees())
                return 1;
            else if (l1.getInscricoees() == l2.getInscricoees())
                return 0;
            else
                return -1;
        }
    }

    public Locais(Convivio convivio, Pessoa pessoa) {
        super(new GridLayout(1, 0), convivio, "LOCAIS");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Collections.sort(pessoa.getLocais(), new Comparator());

        for (Local local : pessoa.getLocais())
            add(new JLabel(local.toString()));

        add(Box.createRigidArea(new Dimension(0, 15)));
        add(sair);

        run();
    }
}
