package world;

import java.util.List;

import item.Loot;
import player.Player;
import userinput.InputHandler;

public class Shop {

    private List<Loot> items;

    public Shop(List<Loot> items) {
        this.items = items;
    }

    public void Shopping(Player player) {
        InputHandler input = new InputHandler();
        
        System.out.println("\n--- SHOP ---");
        for (int i = 0; i < items.size(); i++) {
            Loot item = items.get(i);
            System.out.println(i + ": " + item.getexlpainloot() + " - Kosten: " + item.getStuff() + " Gold");
        }
        System.out.println("-1: Beenden");
        
        int choice = input.getInt("\nWas möchtest du kaufen? ");
        
        if (choice >= 0 && choice < items.size()) {
            Loot selectedItem = items.get(choice);
            
            if (player.getMoney() >= selectedItem.getStuff()) {
                player.changeMoney(-selectedItem.getStuff());
                player.addItem(selectedItem);
                System.out.println("Du hast " + selectedItem.getexlpainloot() + " gekauft!");
                System.out.println("Geld übrig: " + player.getMoney());
            } else {
                System.out.println("Du hast nicht genug Geld!");
            }
        } else if (choice != -1) {
            System.out.println("Ungültige Auswahl!");
        }
    }

    public List<Loot> getItems() {
        return items;
    }

    public List<Loot> setItems(List<Loot> items) {
        this.items = items;
        return this.items;
    }
}
