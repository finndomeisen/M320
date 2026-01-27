package item;

public class Glasses extends Loot {

    private int power;
    private String rarity;

    public Glasses() {
        super("Mysterious Glasses found in a random shop. ", 30);
        this.power = 1;
        this.rarity = "Uncommon";
    }

    public int getPower() {
        return power;
    }

    public String getRarity() {
        return rarity;
    }
}
