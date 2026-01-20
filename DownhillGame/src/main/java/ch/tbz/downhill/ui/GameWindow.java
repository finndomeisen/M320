package ch.tbz.downhill.ui;

import ch.tbz.downhill.game.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Haupt-Fenster für das Spiel
 */
public class GameWindow extends JFrame implements KeyListener {
    private GamePanel gamePanel;

    public GameWindow() {
        setTitle("2D Abfahrtsspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel();
        add(gamePanel);
        addKeyListener(this);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void start() {
        setFocusable(true);
        gamePanel.startGameLoop();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gamePanel.movePlayerLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gamePanel.movePlayerRight();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            gamePanel.jumpPlayer();
        } else if (e.getKeyCode() == KeyEvent.VK_R && gamePanel.isGameOver()) {
            gamePanel.resetGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
