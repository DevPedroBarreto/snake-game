package main;

import painel.Painel;

import javax.swing.*;


public class Main {
    public static void main(String[] args){
        JFrame janela = new JFrame();
        janela.setTitle("Snake Pedro");
        janela.setSize(1000, 1000);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        Painel painel = new Painel();
        janela.add(painel);

        janela.setVisible(true);
    }
}
