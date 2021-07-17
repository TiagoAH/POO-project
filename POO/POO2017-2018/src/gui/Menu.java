package gui;

import objectos.Convivio;
import objectos.pessoas.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Menu extends GUIObject {

    private final Pessoa pessoa;

    public Menu(Convivio convivio, Pessoa pessoa) {
        super(new GridLayout(1, 0), convivio, "BEM - VINDO");

        this.pessoa = pessoa;

        JLabel bemvindo = new JLabel("Seja bem-vindo " + pessoa.getUsername() + " ao Convívio do DEI");
        JButton receitas = new JButton("VISUALIZAR RECEITAS"),
                guestLists = new JButton("VISUALIZAR GUEST-LISTS"),
                locais = new JButton("VISUALIZAR LOCAIS A VISITAR");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        receitas.addActionListener(new ActionListener(this, "receitas"));
        guestLists.addActionListener(new ActionListener(this, "guestlists"));
        locais.addActionListener(new ActionListener(this, "locais"));

        bemvindo.setAlignmentX(Component.CENTER_ALIGNMENT);
        receitas.setAlignmentX(Component.CENTER_ALIGNMENT);
        guestLists.setAlignmentX(Component.CENTER_ALIGNMENT);
        locais.setAlignmentX(Component.CENTER_ALIGNMENT);
        sair.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(bemvindo);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(receitas);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(guestLists);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(locais);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(sair);

        run();
    }

    private class ActionListener implements java.awt.event.ActionListener {
        private final GUIObject panel;
        private final String command;

        public ActionListener(GUIObject panel, String command) {
            this.panel = panel;
            this.command = command;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            int contador;
            switch (command) {
                case "guestlists":
                    new GuestLists(convivio);
                    break;

                case "locais":
                    new Locais(convivio, pessoa);
                    break;

                case "receitas":
                    new Receitas(convivio);
                    break;
            }
        }
    }
}