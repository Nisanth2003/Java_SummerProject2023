package worldclockdemo;
//x/o game	
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class game1 extends JFrame {
    private JButton[][] buttons;
    private char currentPlayer;
    //game1() constructor initialize game window 
    public game1() {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        currentPlayer = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 50));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().equals("")) {
                buttons[row][col].setText(String.valueOf(currentPlayer));
                buttons[row][col].setEnabled(false);
                if (checkWin(currentPlayer)) {
                    JOptionPane.showMessageDialog(game1.this, "Player " + currentPlayer + " wins!");
                    resetBoard();
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(game1.this, "It's a draw!");
                    resetBoard();
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    private boolean checkWin(char player) {
        // Check rows, columns, and diagonals for a win
        return (buttons[0][0].getText().equals(String.valueOf(player)) && buttons[0][1].getText().equals(String.valueOf(player)) && buttons[0][2].getText().equals(String.valueOf(player))) ||
               (buttons[1][0].getText().equals(String.valueOf(player)) && buttons[1][1].getText().equals(String.valueOf(player)) && buttons[1][2].getText().equals(String.valueOf(player))) ||
               (buttons[2][0].getText().equals(String.valueOf(player)) && buttons[2][1].getText().equals(String.valueOf(player)) && buttons[2][2].getText().equals(String.valueOf(player))) ||
               (buttons[0][0].getText().equals(String.valueOf(player)) && buttons[1][0].getText().equals(String.valueOf(player)) && buttons[2][0].getText().equals(String.valueOf(player))) ||
               (buttons[0][1].getText().equals(String.valueOf(player)) && buttons[1][1].getText().equals(String.valueOf(player)) && buttons[2][1].getText().equals(String.valueOf(player))) ||
               (buttons[0][2].getText().equals(String.valueOf(player)) && buttons[1][2].getText().equals(String.valueOf(player)) && buttons[2][2].getText().equals(String.valueOf(player))) ||
               (buttons[0][0].getText().equals(String.valueOf(player)) && buttons[1][1].getText().equals(String.valueOf(player)) && buttons[2][2].getText().equals(String.valueOf(player))) ||
               (buttons[0][2].getText().equals(String.valueOf(player)) && buttons[1][1].getText().equals(String.valueOf(player)) && buttons[2][0].getText().equals(String.valueOf(player)));
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        currentPlayer = 'X';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            game1 game = new game1();
            game.setVisible(true);
        });
    }
}
