package gui;

import objectos.Convivio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class GUIObject extends JPanel {

    protected Convivio convivio;
    protected String titulo;
    protected JButton sair;

    public GUIObject(GridLayout gridLayout, Convivio convivio, String titulo) {
        super(gridLayout);
        this.convivio = convivio;
        this.titulo = titulo;
        sair = new JButton("SAIR");

        sair.addActionListener(new ActionListener(this));
    }

    protected void run() {
        JFrame frame = new JFrame(titulo);
        setOpaque(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected void runScrollPane() {
        JFrame frame = new JFrame(titulo);
        setOpaque(true);
        JScrollPane jScrollPane = new JScrollPane(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(jScrollPane);
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setMaximumSize(DimMax);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected void close(JPanel panel) {
        ((JFrame) SwingUtilities.getRoot(panel)).dispose();
    }

    public String getTitulo() {
        return titulo;
    }

    protected void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "MENSAGEM ERRO", JOptionPane.ERROR_MESSAGE);
    }

    private class ActionListener implements java.awt.event.ActionListener {
        private final GUIObject panel;

        public ActionListener(GUIObject panel) {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            close(panel);
        }
    }
}
