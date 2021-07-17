package gui;

import objectos.Convivio;
import objectos.pessoas.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Login extends GUIObject {

    public final JTextField username;
    public final JPasswordField password;

    public Login(Convivio convivio) {
        super(new GridLayout(1, 0), convivio, "LOGIN");

        this.username = new JTextField(20);
        this.password = new JPasswordField(20);

        JPanel username = new JPanel(),
                password = new JPanel(),
                buttons = new JPanel();
        JButton login = new JButton("LOGIN");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        login.addActionListener(new ActionListener(this));

        username.add(new JLabel("Username"));
        username.add(this.username);

        password.add(new JLabel("Password"));
        password.add(this.password);

        buttons.add(login);
        buttons.add(sair);

        add(new JLabel("BEM-VINDO"));
        add(username);
        add(password);
        add(buttons);

        run();
    }

    private class ActionListener implements java.awt.event.ActionListener {
        private final GUIObject panel;

        public ActionListener(GUIObject panel) {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                Pessoa pessoa = panel.convivio.login(username.getText(), String.valueOf(password.getPassword()));
                if (pessoa.getLocais().isEmpty())
                    new Inscricao(convivio, pessoa);
                else
                    new Menu(convivio, pessoa);
                close(panel);
            } catch (Exception e) {
                showErrorMessage(e.getMessage());
            }
        }
    }
}
