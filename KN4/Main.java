import combat.Combat;
import item.Loot;
import player.Player;
import world.*;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Geben sie einen Namen an: ");
    String name = scanner.nextLine();
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

        int choice = scanner.nextInt();

        if (choice == 1) {
          System.out.println("Shop Inhalte:");
          for (Loot item : settlement.getShop().getItems()) {
            System.out.println("- " + item.getexlpainloot());
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
        scanner.nextInt();
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

    scanner.close();
  }
}
