package KN4.game.entity;

public class Enemy {

    private final String type;
    private int health;
    private final int attack;

    public Enemy(String type, int health, int attack) {
        this.type = type;
        this.health = health;
        this.attack = attack;
    }

    public int attackPlayer() {
        return attack;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }
}
