package world;

import java.util.ArrayList;
import enemy.*;
import item.Loot;

public class Room {
    private String explainroom;
    private ArrayList<Enemy> enemies;
    private ArrayList<Loot> loots;

    public Room(String explain, ArrayList<Enemy> enemies, ArrayList<Loot> loots) {
        this.explainroom = explain;
        this.enemies = enemies;
        this.loots = loots;
    }

    public String getExplainRoom() {
        return explainroom;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Loot> getLoots() {
        return loots;
    }
}
