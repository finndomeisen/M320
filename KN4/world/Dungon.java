package world;

import java.util.ArrayList;
import item.Loot;
import enemy.*;

public class Dungon extends Maps {

    private ArrayList<Room> rooms = new ArrayList<>();

    public Dungon() {
        super("DU stehtst am anfang eines dungeons");
    }

    public void generateDungeon(int difficulty) {
        rooms.clear();

        int roomCount;

        if (difficulty == 1) {
            roomCount = 3;
        } else if (difficulty == 2) {
            roomCount = 5;
        } else {
            roomCount = 8;
        }

        for (int i = 0; i < roomCount; i++) {
            rooms.add(createRoomByDifficulty(difficulty));
        }
    }

    private Room createRoomByDifficulty(int difficulty) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        ArrayList<Loot> loots = new ArrayList<>();

        if (difficulty == 1) {
            enemies.add(new Goblin());
            loots.add(new Loot("Kleine Kiste", 5));
        }
        else if (difficulty == 2) {
            enemies.add(new Goblin());
            enemies.add(new Goblin());
            loots.add(new Loot("Mittlere Truhe", 10));
        }
        else {
            enemies.add(new Goblin());
            enemies.add(new Goblin());
            enemies.add(new Goblin());
            loots.add(new Loot("Grosse Truhe", 20));
        }

        return new Room("Ein dunkler Raum im Dungeon", enemies, loots);
    }

    public ArrayList<Room> getrooms() {
        return rooms;
    }
}
