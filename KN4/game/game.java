package KN4.game;

public class game {

    private boolean running;
    private User player;

    public void startGame() {
        printWelcome();
        createPlayer();
        gameLoop();
        endGame();
    }

    private void printWelcome() {
        System.out.println("Willkommen zum RPG CLI Spiel");
        System.out.println("============================");
    }

    private void createPlayer() {
        String name = InputHelper.readString("Gib deinen Namen ein:");
        player = new Player(name);
        System.out.println("Spieler erstellt: " + player.getName());
    }

    private void gameLoop() {
        running = true;

        while (running) {
            printMenu();
            int choice = InputHelper.readInt("Deine Wahl:");

            switch (choice) {
                case 1:
                    startFight();
                    break;
                case 2:
                    player.printStatus();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Ungueltige Eingabe");
            }
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
        System.out.println("Kampfsystem folgt spaeter");
    }

    private void endGame() {
        System.out.println("Danke fuers Spielen");
    }
}
