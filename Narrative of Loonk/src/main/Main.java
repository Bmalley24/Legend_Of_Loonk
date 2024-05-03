package main;

import javax.swing.*;

public class Main {
    public static void main(String[] argus) {

        //This File Runs the Games and Initiates the game window wherre you play

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Narrative of Loonk");

        GamingPanel gamingPanel = new GamingPanel();
        window.add(gamingPanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamingPanel.setupGame();
        gamingPanel.startGameThread();

    }
}
