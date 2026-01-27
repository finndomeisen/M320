import combat.Combat;
import item.Loot;
import player.Player;
import world.*;
import enemy.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    System.out.print("Geben sie einen Namen an: ");
    String name = scanner.nextLine();
    Player player = new Player(name, 20);

    System.out.println("Hello " + player.getName());

    // Welt generieren
    MapGen mapGen = new MapGen();
    mapGen.generateWorld();
    ArrayList<Maps> world = mapGen.getWorld();

    // Start immer im world.Settlement
    Maps currentLocation = world.get(0);

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
          currentLocation = getRandomLocation(world, random);
        }
      }

      else if (currentLocation instanceof Dungon dungeon) {

        if (dungeon.getrooms().isEmpty()) {
          dungeon.generateDungeon(1 + random.nextInt(3));
        }

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
        int choice = scanner.nextInt();

        if (choice == 1) {
          currentLocation = getRandomLocation(world, random);
        }
      }
    }

    scanner.close();
  }

  private static Maps getRandomLocation(ArrayList<Maps> world, Random random) {
    Maps location = world.get(random.nextInt(world.size()));

    // Falls Dungeon leer ist, neuen erzeugen
    if (location instanceof Dungon dungeon && dungeon.getrooms().isEmpty()) {
      dungeon.generateDungeon(1 + random.nextInt(3));
    }

    return location;
  }
}
