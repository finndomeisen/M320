package D3;

import java.util.Scanner;

public class PokemonSelector {

    public String selectPokemon() throws PokemonApiException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wähle ein Pokémon-Ei aus:");
        System.out.println("1. Ei 1 ");
        System.out.println("2. Ei 2 ");
        System.out.println("3. Ei 3 ");

        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.print("Deine Wahl (1-3): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Ungültige Wahl. Bitte wähle 1, 2 oder 3.");
                }
            } else {
                System.out.println("Bitte gib eine Zahl ein.");
                scanner.next(); // consume invalid input
            }
        }

        int randomNum = (int) (Math.random() * 101) + 1;
        if (randomNum < 1 || randomNum > 101) {
            throw new PokemonApiException("Ungültige Zufallszahl: " + randomNum);
        }
        String url = "https://pokeapi.co/api/v2/pokemon-form/" + randomNum;
        return url;
    }
}
