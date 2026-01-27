package world;

import item.Loot;
import java.util.List;

public class Shop {

    private List<Loot> items;

    public Shop(List<Loot> items) {
        this.items = items;
    }

    public List<Loot> getItems() {
        return items;
    }
}
