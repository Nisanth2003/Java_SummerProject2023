package worldclockdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gaming {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Game Launcher");
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();
            //to arrange button in gride pattern
            JButton ticTacToeButton = new JButton("Tic-Tac-Toe");
            JButton snakeGameButton = new JButton("Snake Game");
            JButton worldMapButton = new JButton("World Map");

            ticTacToeButton.addActionListener(e -> game1.main(new String[0])); // Run Tic-Tac-Toe game
            snakeGameButton.addActionListener(e -> game2.main(new String[0])); // Run Snake game
            worldMapButton.addActionListener(e -> Mainframe.main(new String[0])); // Run World Map
            //grid bag constraints ,positioning of button in panal
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.insets = new Insets(20, 20, 20, 20);
            panel.add(ticTacToeButton, constraints);

            constraints.gridx = 0;
            constraints.gridy = 1;
            panel.add(snakeGameButton, constraints);

            constraints.gridx = 0;
            constraints.gridy = 2;
            panel.add(worldMapButton, constraints);

            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // Use a custom icon for the frame
            ImageIcon icon = new ImageIcon("icon.png"); // Provide the path to your icon image
            frame.setIconImage(icon.getImage());

            // Set a nice look and feel
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(frame);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            frame.setVisible(true);
        });
    }
}

