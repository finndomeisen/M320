abstract class Weapon {
    protected String name;
    protected int damage;
    protected String rarity;
    // es gibt private, public und protected, protected bedeutet dass nicht alle zugreifen können, sondern nur die eigene Klasse,
    // alle Unterklassen und alle Klassen im gleichen Package

    public Weapon(String name, int damage, String rarity) {
        this.name = name;
        this.damage = damage;
        this.rarity = rarity;
        // man braucht es wenn die Parameter gleich heissen
    }

    static int DamageRechner(int zahl1, int zahl2, int zahl3) {
        return zahl1 + zahl2 + zahl3;
    }

    static int DamageRechner(int zahl1, int zahl2){
        return zahl1 + zahl2;
    }

    // jede Waffe hat einen eigenen fire Effekt
    public abstract void fire();
    public void info() {
        System.out.println(name + " - Damage: " + damage + " - Rarity: " + rarity);
    }
}

// Unterklasse: Shotgun
class Shotgun extends Weapon {
    

    public Shotgun(String rarity) {
        super("Pump Shotgun", DamageRechner(100, 25), rarity);
           
    }

    @Override
    public void fire() {
        System.out.println("HANG! Gegner wird zur Loot Pinata");
    }
}
// Unterklasse: Assault Rifle
class AssaultRifle extends Weapon {

    public AssaultRifle(String rarity) {
        super("Scar", 35, rarity);
    }

    @Override
    public void fire() {
        System.out.println("SKR POW! SKR POW! RATATATA!");
    }
}

// Unterklasse: Sniper
class Sniper extends Weapon {

    public Sniper(String rarity) {
        super("Heavy Sniper", 143, rarity);
    }

    @Override
    public void fire() {
        System.out.println("POOOOWWWWWW!!!! Aus dem Leben geschallert!");
    }
}

public class MainA {
    public static void main(String[] args) {
        Weapon w1 = new Shotgun("Legendary");
        Weapon w2 = new AssaultRifle("Epic");
        Weapon w3 = new Sniper("Rare");

        w1.info();
        w1.fire();

        w2.info();
        w2.fire();
        
        w3.info();
        w3.fire();
    }
}
