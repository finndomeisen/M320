package world;

import item.Loot;
import player.Player;

import java.util.List;

public class Shop {

    private List<Loot> items;

    public Shop(List<Loot> items) {
        this.items = items;
    }

    public Loot Shopping(Player){

    }

    public List<Loot> getItems() {
        return items;
    }

    public List<Loot> setItems(List<Loot> items) {
        this.items = items;
        return this.items;
    }
}
