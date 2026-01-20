package KN4.game;

import java.util.Scanner;

import KN4.game.entity.Enemy;
import KN4.game.entity.User;

public class Game {

    private boolean running;
    private User player;

    public void startGame() {
        printWelcome();
        createPlayer();
        gameLoop();
        endGame();
        System.out.println("\nSpiel beendet!");
    }

    private void printWelcome() {
        System.out.println("Willkommen zum RPG CLI Spiel");
        System.out.println("============================");
    }

    private void createPlayer() {
        String name = readString("Gib deinen Namen ein:");
        player = new User(name, 100, 10);
        System.out.println("Spieler erstellt: " + player.getName());
    }

    private void gameLoop() {
        running = true;

        while (running) {
            printMenu();
            int choice = readInt("Deine Wahl:");

            switch (choice) {
                case 1 -> startFight();
                case 2 -> player.printStatus();
                case 3 -> running = false;
                default -> System.out.println("Ungueltige Eingabe");
            }
        }
    }

    private void exploreEnvironment() {
        System.out.println("\nUmgebung wird erkundet...");
        int enemyCount = (int) (Math.random() * 3); // 0-2 Feinde
        
        if (enemyCount == 0) {
            System.out.println("Keine Monster gefunden.");
            return;
        }
        
        Enemy[] enemies = new Enemy[enemyCount];
        enemies[0] = new Enemy("Goblin", 30, 5);
        if (enemyCount > 1) {
            enemies[1] = new Enemy("Orc", 50, 8);
        }
        
        System.out.println(enemyCount + " Monster gefunden!");
        for (int i = 0; i < enemies.length; i++) {
            System.out.println((i + 1) + ". " + enemies[i].getType());
        }
        
        int choice = readInt("Welches Monster angreifen? (0 zum Abbrechen):");
        if (choice > 0 && choice <= enemies.length) {
            startFight(enemies[choice - 1]);
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1 Kaempfen");
        System.out.println("2 Status anzeigen");
        System.out.println("3 Spiel beenden");
    }

    private void startFight() {
        Enemy enemy = new Enemy("Goblin", 30, 5);
        System.out.println("Ein " + enemy.getType() + " erscheint");
        
        boolean fightRunning = true;
        while (fightRunning && player.isAlive() && enemy.isAlive()) {
            System.out.println("\nDein Health: " + player.getHealth() + " | Enemy Health: " + enemy.getHealth());
            int playerDamage = player.attackEnemy();
            enemy.takeDamage(playerDamage);
            System.out.println("Du machst " + playerDamage + " Schaden!");
            
            if (!enemy.isAlive()) {
                System.out.println("Monster besiegt!");
                player.gainExperience(50);
                fightRunning = false;
            } else {
                int enemyDamage = enemy.attackEnemy();
                player.takeDamage(enemyDamage);
                System.out.println("Monster macht " + enemyDamage + " Schaden!");
                
                if (!player.isAlive()) {
                    System.out.println("Du bist besiegt!");
                    fightRunning = false;
                }
            }
        }
    }

    private void startFight(Enemy enemy) {
        System.out.println("\nKampf gegen " + enemy.getType() + "!");
        
        boolean fightRunning = true;
        while (fightRunning && player.isAlive() && enemy.isAlive()) {
            System.out.println("\nDein Health: " + player.getHealth() + " | Enemy Health: " + enemy.getHealth());
            int playerDamage = player.attackEnemy();
            enemy.takeDamage(playerDamage);
            System.out.println("Du machst " + playerDamage + " Schaden!");
            
            if (!enemy.isAlive()) {
                System.out.println("Monster besiegt!");
                player.gainExperience(50);
                fightRunning = false;
            } else {
                int enemyDamage = enemy.attackEnemy();
                player.takeDamage(enemyDamage);
                System.out.println("Monster macht " + enemyDamage + " Schaden!");
                
                if (!player.isAlive()) {
                    System.out.println("Du bist besiegt!");
                    fightRunning = false;
                }
            }
        }
    }

    private void printStatus() {
        System.out.println("\n=== SPIELERSTATUS ===");
        System.out.println("Name: " + player.getName());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Experience: " + player.getExperience());
        System.out.println("Lebt: " + (player.isAlive() ? "Ja" : "Nein"));
        System.out.println("===================");
    }

    private void endGame() {
        System.out.println("Danke fuers Spielen");
    }

    private static String readString(String prompt) {
        System.out.print(prompt + " ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int readInt(String prompt) {
        System.out.print(prompt + " ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
