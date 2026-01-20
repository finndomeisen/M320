package KN4.game.entity;
public class user {

    // Attribute
    private String name;
    private int health;
    private int attack;
    private int experience;

    // Konstruktor
    public Player(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.experience = 0;
    }

    // Methoden
    public int attackEnemy() {
        return attack;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void gainExperience(int amount) {
        experience += amount;
    }

    // Getter (praktisch fürs Game)
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
