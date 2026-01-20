package ch.tbz.downhill.ui;

import ch.tbz.downhill.game.GameEngine;
import ch.tbz.downhill.game.Obstacle;
import ch.tbz.downhill.game.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Zeichnungs- und Renderung-Panel
 */
public class GamePanel extends JPanel {
    private GameEngine engine;
    private Thread gameThread;
    private volatile boolean running;

    public GamePanel() {
        setBackground(new Color(135, 206, 235)); // Himmelblau
        engine = new GameEngine(800, 600);
        running = false;
    }

    public void startGameLoop() {
        if (gameThread == null) {
            gameThread = new Thread(this::gameLoop);
            running = true;
            gameThread.start();
        }
    }

    private void gameLoop() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                engine.update();
                repaint();
                delta--;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Spieler zeichnen
        Player player = engine.getPlayer();
        g2d.setColor(Color.RED);
        g2d.fillRect((int) player.getX(), (int) player.getY(), 
                     (int) player.getWidth(), (int) player.getHeight());
        g2d.setColor(Color.DARK_RED);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect((int) player.getX(), (int) player.getY(), 
                     (int) player.getWidth(), (int) player.getHeight());

        // Hindernisse zeichnen
        g2d.setColor(Color.BLACK);
        for (Obstacle obstacle : engine.getObstacles()) {
            g2d.fillRect((int) obstacle.getX(), (int) obstacle.getY(), 
                         (int) obstacle.getWidth(), (int) obstacle.getHeight());
        }

        // Score anzeigen
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("Score: " + engine.getScore(), 20, 40);

        // Game Over Nachricht
        if (engine.isGameOver()) {
            g2d.setColor(new Color(0, 0, 0, 150));
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 48));
            String gameOverText = "GAME OVER!";
            FontMetrics fm = g2d.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(gameOverText)) / 2;
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
            g2d.drawString(gameOverText, x, y);

            g2d.setFont(new Font("Arial", Font.PLAIN, 24));
            String restartText = "Press R to restart";
            fm = g2d.getFontMetrics();
            x = (getWidth() - fm.stringWidth(restartText)) / 2;
            y = y + 60;
            g2d.drawString(restartText, x, y);
        }
    }

    public void movePlayerLeft() {
        engine.movePlayerLeft();
    }

    public void movePlayerRight() {
        engine.movePlayerRight();
    }

    public void jumpPlayer() {
        engine.jumpPlayer();
    }

    public boolean isGameOver() {
        return engine.isGameOver();
    }

    public void resetGame() {
        engine.reset();
    }
}
