package ch.tbz.downhill.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Spiel-Engine für das Abfahrtsspiel
 */
public class GameEngine {
    private Player player;
    private List<Obstacle> obstacles;
    private int score;
    private boolean gameOver;
    private int screenWidth;
    private int screenHeight;
    private int obstacleSpawnCounter;
    private Random random;

    public GameEngine(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;
        this.player = new Player(width / 2, 50);
        this.obstacles = new ArrayList<>();
        this.score = 0;
        this.gameOver = false;
        this.obstacleSpawnCounter = 0;
        this.random = new Random();
    }

    public void update() {
        if (gameOver) return;

        // Spieler aktualisieren
        player.update(screenWidth, screenHeight);

        // Hindernisse aktualisieren
        Iterator<Obstacle> iterator = obstacles.iterator();
        while (iterator.hasNext()) {
            Obstacle obstacle = iterator.next();
            obstacle.update();

            // Kollisionserkennung
            if (obstacle.collidesWith(player)) {
                gameOver = true;
            }

            // Hindernisse entfernen wenn off-screen
            if (obstacle.isOffScreen()) {
                iterator.remove();
                score += 10;
            }
        }

        // Neue Hindernisse spawnen
        obstacleSpawnCounter++;
        if (obstacleSpawnCounter > 40) {
            spawnObstacle();
            obstacleSpawnCounter = 0;
        }
    }

    private void spawnObstacle() {
        double x = random.nextDouble() * (screenWidth - 40);
        obstacles.add(new Obstacle(x, -30, 40, 20));
    }

    public void movePlayerLeft() {
        player.moveLeft();
    }

    public void movePlayerRight() {
        player.moveRight();
    }

    public void jumpPlayer() {
        player.jump();
    }

    public Player getPlayer() {
        return player;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void reset() {
        player = new Player(screenWidth / 2, 50);
        obstacles.clear();
        score = 0;
        gameOver = false;
        obstacleSpawnCounter = 0;
    }
}
