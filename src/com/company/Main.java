package com.company;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        Game game = new Game();

        JFrame frame = new JFrame("Game Frame");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }

}
