package gui;

import files.FicheiroObjectos;
import objectos.Convivio;
import objectos.pessoas.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class Inscricao extends GUIObject {

    private final Pessoa pessoa;
    private final LinkedList<Local> locais;

    public Inscricao(Convivio convivio, Pessoa pessoa) {
        super(new GridLayout(1, 0), convivio, "ESCOLHER LOCAIS A VISITAR");

        this.pessoa = pessoa;
        this.locais = new LinkedList<>();

        JPanel info = new JPanel(),
                locais = new JPanel(),
                checks = new JPanel(),
                buttons = new JPanel();
        JButton inscrever = new JButton("INSCREVER");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        locais.setLayout(new BoxLayout(locais, BoxLayout.Y_AXIS));
        checks.setLayout(new BoxLayout(checks, BoxLayout.Y_AXIS));;

        inscrever.addActionListener(new ActionListener(this, "inscrever"));

        for (objectos.locais.Local local : convivio.getLocais())
            this.locais.add(new Local(this, local));

        for (Local local : this.locais)
            local.toJPanel(locais, checks);

        info.add(locais);
        info.add(checks);

        buttons.add(inscrever);
        buttons.add(sair);

        add(info);
        add(buttons);

        runScrollPane();
    }

    private class ActionListener implements java.awt.event.ActionListener {
        private final GUIObject panel;
        private final String command;

        public ActionListener(GUIObject panel, String command) {
            this.panel = panel;
            this.command = command;
        }

        private int contar() {
            int contador = 0;
            for (Local local : locais)
                if (local.checkBox.isSelected())
                    contador++;
            return contador;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            int contador;
            switch (command) {
                case "selecionar":
                    contador = contar();

                    if (contador == 5) {
                        for (Local local : locais)
                            if (!local.checkBox.isSelected())
                                local.checkBox.setEnabled(false);
                    } else
                        for (Local local : locais)
                            local.checkBox.setEnabled(true);
                    break;

                case "inscrever":
                    contador = contar();

                    if (contador > 0 && contador <= 5) {
                        for (Local local : locais)
                            if (local.checkBox.isSelected())
                                pessoa.add(local.local);
                        new Menu(convivio, pessoa);
                        FicheiroObjectos.write(convivio);
                        close(panel);
                    } else
                        showErrorMessage("Escolha pelo menos um local!");
                    break;
            }
        }
    }

    private class Local {
        private JCheckBox checkBox;
        private objectos.locais.Local local;

        public Local(GUIObject panel, objectos.locais.Local local) {
            this.local = local;
            checkBox = new JCheckBox();
            checkBox.addActionListener(new ActionListener(panel, "selecionar"));
        }

        public void toJPanel(JPanel locais, JPanel checks) {
            locais.add(Box.createRigidArea(new Dimension(0, 2)));
            locais.add(new JLabel(local.toString()));
            locais.add(Box.createRigidArea(new Dimension(0, 3)));
            checks.add(checkBox);
        }
    }
}
