package main;

import files.FicheiroObjectos;
import gui.Login;

public class Main {
    public static void main(String[] args) {
        new Login(FicheiroObjectos.read());
    }
}
