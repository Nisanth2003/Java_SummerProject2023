
package worldclockdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class game2 extends JPanel implements ActionListener {
    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private ArrayList<Point> snake = new ArrayList<>();
    private Point food;
    private boolean gameOver = false;
    private boolean directionRight = true;
    private boolean directionLeft = false;
    private boolean directionUp = false;
    private boolean directionDown = false;

    private Timer timer;

    public game2() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (!gameOver) {
                    if ((key == KeyEvent.VK_LEFT) && (!directionRight)) {
                        directionLeft = true;
                        directionUp = false;
                        directionDown = false;
                    }
                    if ((key == KeyEvent.VK_RIGHT) && (!directionLeft)) {
                        directionRight = true;
                        directionUp = false;
                        directionDown = false;
                    }
                    if ((key == KeyEvent.VK_UP) && (!directionDown)) {
                        directionUp = true;
                        directionRight = false;
                        directionLeft = false;
                    }
                    if ((key == KeyEvent.VK_DOWN) && (!directionUp)) {
                        directionDown = true;
                        directionRight = false;
                        directionLeft = false;
                    }
                } else {
                    // Restart the game on spacebar press when game is over
                    if (key == KeyEvent.VK_SPACE) {
                        initializeGame();
                        timer.start();
                        gameOver = false; // Reset the game over status
                        repaint();
                    }
                }
            }
        });

        initializeGame();
    }

    private void initializeGame() {
        snake.clear();
        snake.add(new Point(5, 5));
        generateFood();
        timer = new Timer(100, this);
        timer.start();
    }

    private void generateFood() {
        Random rand = new Random();
        int x = rand.nextInt(WIDTH / TILE_SIZE);
        int y = rand.nextInt(HEIGHT / TILE_SIZE);
        food = new Point(x, y);
    }

    private void move() {
        Point newHead = (Point) snake.get(0).clone();

        if (directionRight) {
            newHead.x++;
        } else if (directionLeft) {
            newHead.x--;
        } else if (directionUp) {
            newHead.y--;
        } else if (directionDown) {
            newHead.y++;
        }

        snake.add(0, newHead);

        if (newHead.equals(food)) {
            generateFood();
        } else {
            snake.remove(snake.size() - 1);
        }

        checkCollisions(newHead);
    }

    private void checkCollisions(Point head) {
        if (head.x < 0 || head.x >= WIDTH / TILE_SIZE || head.y < 0 || head.y >= HEIGHT / TILE_SIZE) {
            gameOver = true;
        }

        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                gameOver = true;
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            move();
            repaint();
        } else {
            timer.stop();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!gameOver) {
            // Draw snake
            g.setColor(Color.GREEN);
            for (Point p : snake) {
                g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }

            // Draw food
            g.setColor(Color.RED);
            g.fillRect(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        } else {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", WIDTH / 2 - 100, HEIGHT / 2);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press SPACE to restart", WIDTH / 2 - 140, HEIGHT / 2 + 40);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        game2 game = new game2();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

