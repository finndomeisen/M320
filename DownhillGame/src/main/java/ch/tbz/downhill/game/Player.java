package ch.tbz.downhill.game;

/**
 * Spieler-Klasse für das Abfahrtsspiel
 */
public class Player {
    private double x;
    private double y;
    private double velocityX;
    private double velocityY;
    private static final double WIDTH = 20;
    private static final double HEIGHT = 30;
    private static final double MAX_VELOCITY = 15;
    private static final double GRAVITY = 0.5;
    private static final double FRICTION = 0.95;

    public Player(double startX, double startY) {
        this.x = startX;
        this.y = startY;
        this.velocityX = 0;
        this.velocityY = 0;
    }

    public void update(int screenWidth, int screenHeight) {
        // Schwerkraft anwenden
        velocityY += GRAVITY;

        // Reibung anwenden
        velocityX *= FRICTION;

        // Maximale Geschwindigkeit begrenzen
        if (Math.abs(velocityY) > MAX_VELOCITY) {
            velocityY = MAX_VELOCITY * (velocityY > 0 ? 1 : -1);
        }

        // Position aktualisieren
        x += velocityX;
        y += velocityY;

        // Grenzen kontrollieren
        if (x < 0) x = 0;
        if (x + WIDTH > screenWidth) x = screenWidth - WIDTH;

        // Am Boden landen
        if (y + HEIGHT >= screenHeight) {
            y = screenHeight - HEIGHT;
            velocityY = 0;
        }
    }

    public void moveLeft() {
        velocityX = -5;
    }

    public void moveRight() {
        velocityX = 5;
    }

    public void jump() {
        if (y + HEIGHT >= 400) { // Nur springen wenn auf dem Boden
            velocityY = -12;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return WIDTH;
    }

    public double getHeight() {
        return HEIGHT;
    }
}
