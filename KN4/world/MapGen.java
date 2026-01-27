package world;

import java.util.LinkedList;

import item.Crown;
import item.Loot;

public class MapGen {

    private LinkedList<Maps> world = new LinkedList<>();
    private int worldLevel = 1;

    public void generateWorld() {
        world.clear();

        // =========================
        // Settlement
        // =========================
        world.add(createSettlement());

        // =========================
        // Dungeons
        // =========================
        world.add(createDungeon(1));
        world.add(createDungeon(2));
        world.add(createDungeon(3));
    }

    private Settlement createSettlement() {
        LinkedList<Loot> shopItems = new LinkedList<>();

        shopItems.add(new Crown());

        Shop shop = new Shop(shopItems);
        return new Settlement(
                "Village Level " + worldLevel,
                shop
        );
    }

    private Dungon createDungeon(int baseDifficulty) {
        Dungon dungeon = new Dungon();
        dungeon.generateDungeon(baseDifficulty + worldLevel);
        return dungeon;
    }

    public void nextWorldLevel() {
        worldLevel++;
        generateWorld();
    }

    public LinkedList<Maps> getWorld() {
        return world;
    }
}
