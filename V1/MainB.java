// Eine Fortnite-Waffe für das Loadout – mit Comparable
class LootWeapon implements Comparable<LootWeapon> {
    private String name;
    private int damage;
    private int rarityLevel; 
    // 1 = Common, 2 = Uncommon, 3 = Rare, 4 = Epic, 5 = Legendary

    public LootWeapon(String name, int damage, int rarityLevel) {
        this.name = name;
        this.damage = damage;
        this.rarityLevel = rarityLevel;
    }

    public int getDamage() { return damage; }
    public String getName() { return name; }
    public int getRarityLevel() { return rarityLevel; }

    // Vergleich: höhere Rarity gewinnt
    @Override
    public int compareTo(LootWeapon other) {
        return Integer.compare(this.rarityLevel, other.rarityLevel);
    }

    @Override
    public String toString() {
        return name + " - Damage: " + damage + " - RarityLevel: " + rarityLevel;
    }
}

// eigene Collection: Fortnite Loadout
class Loadout extends java.util.ArrayList<LootWeapon> {

    // eigener Iterator
    @Override
    public java.util.Iterator<LootWeapon> iterator() {
        return new java.util.Iterator<LootWeapon>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public LootWeapon next() {
                return get(index++);
            }
        };
    }

    // eigene Methode: beste Waffe
    public LootWeapon getBestWeapon() {
        return this.stream().max(LootWeapon::compareTo).orElse(null);
    }
}

public class MainB {
    public static void main(String[] args) {
        Loadout loadout = new Loadout();

        loadout.add(new LootWeapon("Pump Shotgun", 110, 5));   // Legendary
        loadout.add(new LootWeapon("Assault Rifle", 35, 4));  // Epic
        loadout.add(new LootWeapon("Heavy Sniper", 143, 3));   // Rare

        System.out.println("Dein Loadout:");
        for (LootWeapon w : loadout) {
            System.out.println(w);
        }

        System.out.println("\nBeste Waffe:");
        System.out.println(loadout.getBestWeapon());
    }
}
