package Q3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AirportApp {

    private HashMap<String, String> airports = new HashMap<>();

    // CSV einlesen
    public void loadFromCsv(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Header ueberspringen

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                airports.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der CSV Datei");
        }
    }

    // Alle Eintraege ausgeben mit Lambda
    public void printAll() {
        airports.forEach((code, name) ->
                System.out.println("Key: " + code + " Value: " + name)
        );
    }

    // Suche nach Airport Code
    public void searchByCode(String code) {
        if (airports.containsKey(code)) {
            System.out.println("Gefunden: " + airports.get(code));
        } else {
            System.out.println("Flughafen nicht gefunden");
        }
    }

    // Suche nach Flughafen Namen
    public void searchByName(String text) {
        airports.forEach((code, name) -> {
            if (name.toLowerCase().contains(text.toLowerCase())) {
                System.out.println(code + " -> " + name);
            }
        });
    }

    // Entfernen mit Iterator
    public void removeByCode(String code) {
        Iterator<Map.Entry<String, String>> iterator = airports.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getKey().equals(code)) {
                iterator.remove();
                System.out.println("Flughafen entfernt: " + code);
            }
        }
    }

    public static void main(String[] args) {
        AirportApp app = new AirportApp();

        app.loadFromCsv("Q3/airports.csv");

        System.out.println("Alle Flughäfen:");
        app.printAll();

        System.out.println("\nSuche nach Code LAX:");
        app.searchByCode("LAX");

        System.out.println("\nSuche nach International:");
        app.searchByName("International");

        System.out.println("\nEntferne JFK:");
        app.removeByCode("JFK");

        System.out.println("\nListe nach dem Entfernen:");
        app.printAll();
    }
}
