package item;

import item.Loot;

public class Crown extends Loot {

    private int power;
    private String rarity;

    public Crown() {
        super("Golden Crown found in a royal chest", 500);
        this.power = 10;
        this.rarity = "Legendary";
    }

    public int getPower() {
        return power;
    }

    public String getRarity() {
        return rarity;
    }
}
