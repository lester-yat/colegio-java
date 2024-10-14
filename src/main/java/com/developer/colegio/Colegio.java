package com.developer.colegio;

import javax.swing.JFrame;
import views.Inicio;
import views.Login;

public class Colegio {
    public static void main(String[] args) {
        Login inicio = new Login();
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
    }
}