import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Nutzer eingeloggterNutzer = null;

    private static Bank bank = new Bank("Zentralbank");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hauptmenu ---");
            System.out.println("1: Nutzer registrieren");
            System.out.println("2: Einloggen");
            System.out.println("3: Ausloggen");
            System.out.println("4: Konto erstellen");
            System.out.println("5: Einzahlen");
            System.out.println("6: Abheben");
            System.out.println("7: Ueberweisen");
            System.out.println("8: Konten anzeigen");
            System.out.println("0: Beenden");
            System.out.print("Auswahl: ");

            int wahl = Integer.parseInt(sc.nextLine());

            switch (wahl) {
                case 1 -> nutzerRegistrieren();
                case 2 -> einloggen();
                case 3 -> ausloggen();
                case 4 -> kontoErstellen();
                case 5 -> einzahlen();
                case 6 -> abheben();
                case 7 -> ueberweisen();
                case 8 -> bank.alleKontenAnzeigen();
                case 0 -> System.exit(0);
                default -> System.out.println("Ungueltige Auswahl.");
            }
        }
    }

    private static void nutzerRegistrieren() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        eingeloggterNutzer = new Nutzer(name);
        System.out.println("Nutzer erstellt und eingeloggt!");
    }

    private static void einloggen() {
        if (eingeloggterNutzer != null) {
            System.out.println("Du bist bereits eingeloggt als: " + eingeloggterNutzer.getName());
            return;
        }
        System.out.print("Name: ");
        String name = sc.nextLine();
        eingeloggterNutzer = new Nutzer(name);
        System.out.println("Eingeloggt als: " + name);
    }

    private static void ausloggen() {
        if (eingeloggterNutzer == null) {
            System.out.println("Kein Nutzer eingeloggt.");
            return;
        }
        eingeloggterNutzer = null;
        System.out.println("Ausgeloggt.");
    }

    private static void kontoErstellen() {
        checkLogin();
        System.out.print("Kontoname: ");
        String name = sc.nextLine();
        bank.kontoErstellen(name, eingeloggterNutzer);
        System.out.println("Konto erstellt!");
    }

    private static void einzahlen() {
        checkLogin();
        Konto k = kontoAuswahl();
        if (k == null) return;

        System.out.print("Betrag: ");
        double b = Double.parseDouble(sc.nextLine());
        k.einzahlen(b);
        System.out.println("Einzahlung erfolgreich.");
    }

    private static void abheben() {
        checkLogin();
        Konto k = kontoAuswahl();
        if (k == null) return;

        System.out.print("Betrag: ");
        double b = Double.parseDouble(sc.nextLine());
        if (!k.abheben(b)) {
            System.out.println("Nicht genug Geld.");
        } else {
            System.out.println("Abhebung erfolgreich.");
        }
    }

    private static void ueberweisen() {
        checkLogin();
        System.out.println("Von welchem Konto?");
        Konto von = kontoAuswahl();
        if (von == null) return;

        System.out.println("Auf welches Konto (Name eingeben)?");
        String zielName = sc.nextLine();
        Konto auf = bank.kontoFinden(zielName);

        if (auf == null) {
            System.out.println("Zielkonto existiert nicht!");
            return;
        }

        System.out.print("Betrag: ");
        double b = Double.parseDouble(sc.nextLine());

        if (!von.abheben(b)) {
            System.out.println("Nicht genug Geld.");
            return;
        }

        auf.einzahlen(b);
        System.out.println("Ueberweisung erfolgreich.");
    }

    private static Konto kontoAuswahl() {
        ArrayList<Konto> meine = bank.getKontenVon(eingeloggterNutzer);

        if (meine.isEmpty()) {
            System.out.println("Du hast keine Konten.");
            return null;
        }

        System.out.println("Deine Konten:");
        for (int i = 0; i < meine.size(); i++) {
            System.out.println((i + 1) + ": " + meine.get(i).getKontoname()
                    + " | Saldo: " + meine.get(i).getSaldo());
        }

        System.out.print("Auswahl: ");
        int wahl = Integer.parseInt(sc.nextLine()) - 1;

        if (wahl < 0 || wahl >= meine.size()) {
            System.out.println("Ungueltig!");
            return null;
        }

        return meine.get(wahl);
    }

    private static void checkLogin() {
        if (eingeloggterNutzer == null) {
            System.out.println("Bitte zuerst einloggen!");
            throw new IllegalStateException("Nicht eingeloggt");
        }
    }
}
