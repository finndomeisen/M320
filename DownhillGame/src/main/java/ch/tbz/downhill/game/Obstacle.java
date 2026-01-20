package ch.tbz.downhill.game;

/**
 * Hindernisse auf der Piste
 */
public class Obstacle {
    private double x;
    private double y;
    private double width;
    private double height;

    public Obstacle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        // Hindernisse bewegen sich nach unten
        y += 3;
    }

    public boolean isOffScreen() {
        return y > 600;
    }

    public boolean collidesWith(Player player) {
        return x < player.getX() + player.getWidth() &&
               x + width > player.getX() &&
               y < player.getY() + player.getHeight() &&
               y + height > player.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
