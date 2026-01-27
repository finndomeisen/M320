package world;

import item.Loot;

import java.util.ArrayList;


public class Shop {

    private ArrayList<Loot> items = new ArrayList<>();

    public Shop(ArrayList<Loot> items) {
        this.items = items;
    }

    public ArrayList<Loot> getItems() {
        return items;
    }
}
