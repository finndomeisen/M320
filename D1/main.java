public class Main {
    public static void main(String[] args) {
        // Zwei Objekte instanziieren
        Auto auto1 = new Auto("Rotes", 50);
        Auto auto2 = new Auto("Blaues", 60);

        // Zustand anzeigen
        System.out.println("Anfangsgeschwindigkeiten:");
        System.out.println(auto1.getFarbe() + " Auto: " + auto1.getGeschwindigkeit() + " km/h");
        System.out.println(auto2.getFarbe() + " Auto: " + auto2.getGeschwindigkeit() + " km/h");

        // Methoden aufrufen -> Zustand ändert sich
        auto1.beschleunigen(20);
        auto2.bremsen(30);

        // Kommunikation zwischen Objekten
        auto1.rennenMit(auto2);
    }
}

