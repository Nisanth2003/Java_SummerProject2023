package worldclockdemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gamelauncher{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Launcher");
        JPanel panel = new JPanel();

        JButton ticTacToeButton = new JButton("Tic-Tac-Toe");
        JButton snakeGameButton = new JButton("Snake Game");

        ticTacToeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game1.main(new String[0]); // Run Tic-Tac-Toe game
            }
        });

        snakeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game2.main(new String[0]); // Run Snake game
            }
        });

        panel.add(ticTacToeButton);
        panel.add(snakeGameButton);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
