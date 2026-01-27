package item;

public class OldBoot extends Loot {

    private int power;
    private String rarity;

    public OldBoot() {
        super("Old, worn boots found in a random shop. ", 5 );
        this.power = 0;
        this.rarity = "Common";
    }

    public int getPower() {
        return power;
    }

    public String getRarity() {
        return rarity;
    }
}
