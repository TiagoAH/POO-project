package gui;

import objectos.Convivio;
import objectos.locais.Bar;
import objectos.locais.Local;
import objectos.pessoas.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.ObjectStreamClass;

public class GuestLists extends GUIObject {

    private final JComboBox bares;
    private final JTextArea guestList;

    public GuestLists(Convivio convivio) {
        super(new GridLayout(1, 0), convivio, "GUEST LISTS");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        bares = new JComboBox();
        guestList = new JTextArea();

        bares.addActionListener(new ActionListener(this));

        for (Local local : convivio.getLocais())
            if (local.isBar())
                bares.addItem(local.getNome());

        add(bares);
        add(guestList);
        add(sair);

        runScrollPane();
    }

    private class ActionListener implements java.awt.event.ActionListener {
        private final GUIObject panel;

        public ActionListener(GUIObject panel) {
            this.panel = panel;
        }

        private Bar getBarByNome(String nome) {
            for (Local local : convivio.getLocais())
                if (nome.equals(local.getNome()))
                    return (Bar) local;
            return null;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            String nome = (String) bares.getSelectedItem();
            guestList.setText("");
            for (Pessoa pessoa : getBarByNome(nome).getGuestList())
                guestList.append(pessoa.toString() + "\n");
        }
    }
}
