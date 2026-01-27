package world;

import java.util.ArrayList;
import item.Loot;

public class MapGen {

    private ArrayList<Maps> world = new ArrayList<>();

    public void generateWorld() {
        world.clear();

        // Dungeon leicht
        Dungon dungeon1 = new Dungon();
        dungeon1.generateDungeon(1);

        // Dungeon schwer
        Dungon dungeon2 = new Dungon();
        dungeon2.generateDungeon(3);

        // world.Settlement mit world.Shop
        ArrayList<Loot> shopItems = new ArrayList<>();
        shopItems.add(new Loot("Health Potion", 10));
        shopItems.add(new Loot("Sword", 50));

        Shop villageShop = new Shop(shopItems);
        Settlement village = new Settlement(
                "A small peaceful village",
                villageShop
        );

        // Alles zur Welt hinzufuegen
        world.add(village);
        world.add(dungeon1);
        world.add(dungeon2);
    }

    public ArrayList<Maps> getWorld() {
        return world;
    }
}
