// Oberklasse - allgemeine Fortnite Waffe
abstract class Weapon {
    protected String name;
    protected int damage;
    protected String rarity;

    public Weapon(String name, int damage, String rarity) {
        this.name = name;
        this.damage = damage;
        this.rarity = rarity;
    }

    // jede Waffe hat einen eigenen "fire"-Effekt
    public abstract void fire();

    public void info() {
        System.out.println(name + " | Damage: " + damage + " | Rarity: " + rarity);
    }
}

// Unterklasse: Shotgun
class Shotgun extends Weapon {

    public Shotgun(String rarity) {
        super("Pump Shotgun", 95, rarity);
    }

    @Override
    public void fire() {
        System.out.println("BOOM! Gegner wird zur Loot Pinata.");
    }
}

// Unterklasse: Assault Rifle
class AssaultRifle extends Weapon {

    public AssaultRifle(String rarity) {
        super("Assault Rifle", 33, rarity);
    }

    @Override
    public void fire() {
        System.out.println("Ratatata! Lasergewehr – eher nicht.");
    }
}

// Unterklasse: Sniper
class Sniper extends Weapon {

    public Sniper(String rarity) {
        super("Bolt Sniper", 110, rarity);
    }

    @Override
    public void fire() {
        System.out.println("KRRACK! Gegner reported dich wegen Aimbot.");
    }
}

public class MainA {
    public static void main(String[] args) {
        Weapon w1 = new Shotgun("Epic");
        Weapon w2 = new AssaultRifle("Rare");
        Weapon w3 = new Sniper("Legendary");

        w1.info();
        w2.info();
        w3.info();

        w1.fire();
        w2.fire();
        w3.fire();
    }
}
