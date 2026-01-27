import java.util.LinkedList;

import combat.Combat;
import player.Player;
import userinput.InputHandler;
import world.Dungon;
import world.MapGen;
import world.Maps;
import world.Room;
import world.Settlement;

public class Main {

  public static void main(String[] args) {

    InputHandler input = new InputHandler();
    String name = input.getString("Geben Sie einen Namen an: ");
    Player player = new Player(name, 20);

    System.out.println("Hello " + player.getName());

    MapGen mapGen = new MapGen();
    mapGen.generateWorld();
    LinkedList<Maps> world = mapGen.getWorld();

    int worldIndex = 0;
    Maps currentLocation = world.getFirst();

    boolean running = true;

    while (running) {

      System.out.println("\n----------------------");
      System.out.println(currentLocation.getexlpeantation());
      System.out.println("----------------------");

      if (currentLocation instanceof Settlement settlement) {

        System.out.println("1 = Shop betreten");
        System.out.println("2 = Weiter reisen");
        System.out.println("3: Inventory");

        int choice = input.getInt("Wählen Sie: ");

        if (choice == 1) {
          settlement.getShop().Shopping(player);
        }

        if (choice == 3){
          // TODO Make Inventory Pretty
          if (player.getInventory() == null){
            System.out.println("You have nothing in your inventory");
          }else {
            System.out.println(player.getInventory());
          }
        }

        if (choice == 2) {
          worldIndex++;
        }
      }

      else if (currentLocation instanceof Dungon dungeon) {

        Room room = dungeon.getrooms().remove(0);

        if (!room.getEnemies().isEmpty()) {
          Combat combat = new Combat(
                  room.getEnemies(),
                  player,
                  room
          );
          combat.startCombat();
        }

        System.out.println("1 = Weiter reisen");
        input.getInt("Weiterreisen: ");
        worldIndex++;
      }

      // =========================
      // Welt-Ende erreicht
      // =========================
      if (worldIndex >= world.size()) {
        mapGen.nextWorldLevel();
        world = mapGen.getWorld();
        worldIndex = 0;
      }

      currentLocation = world.get(worldIndex);
    }

    input.closeScanner();
  }
}
