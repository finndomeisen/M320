import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> konten = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- Bank Menü ---");
            System.out.println("1: Konto erstellen");
            System.out.println("2: Einzahlen");
            System.out.println("3: Abheben");
            System.out.println("4: Ueberweisen");
            System.out.println("5: Konten anzeigen");
            System.out.println("0: Beenden");
            System.out.print("Auswahl: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name fuer neues Konto: ");
                    String name = sc.nextLine();
                    konten.add(new BankAccount(name));
                    System.out.println("Konto fuer " + name + " erstellt.");
                    break;

                case 2:
                    if (konten.isEmpty()) {
                        System.out.println("Keine Konten vorhanden.");
                        break;
                    }
                    BankAccount kEinzahlen = waehleKonto(konten, sc);
                    System.out.print("Betrag einzahlen: ");
                    kEinzahlen.deposit(sc.nextDouble());
                    break;

                case 3:
                    if (konten.isEmpty()) {
                        System.out.println("Keine Konten vorhanden.");
                        break;
                    }
                    BankAccount kAbheben = waehleKonto(konten, sc);
                    System.out.print("Betrag abheben: ");
                    kAbheben.withdraw(sc.nextDouble());
                    break;

                case 4:
                    if (konten.size() < 2) {
                        System.out.println("Mindestens zwei Konten noetig.");
                        break;
                    }

                    System.out.println("Von welchem Konto?");
                    BankAccount von = waehleKonto(konten, sc);

                    System.out.println("Auf welches Konto?");
                    BankAccount zu = waehleKonto(konten, sc);

                    System.out.print("Betrag ueberweisen: ");
                    double betrag = sc.nextDouble();

                    von.transfer(zu, betrag);
                    break;

                case 5:
                    if (konten.isEmpty()) {
                        System.out.println("Keine Konten vorhanden.");
                    } else {
                        for (int i = 0; i < konten.size(); i++) {
                            BankAccount k = konten.get(i);
                            System.out.println(i + ": " + k.getOwner() + " hat " + k.getBalance() + " CHF");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Programm beendet.");
                    break;

                default:
                    System.out.println("Ungueltige Eingabe.");
            }

        } while (choice != 0);

        sc.close();
    }

    public static BankAccount waehleKonto(ArrayList<BankAccount> konten, Scanner sc) {
        for (int i = 0; i < konten.size(); i++) {
            System.out.println(i + ": " + konten.get(i).getOwner());
        }
        System.out.print("Konto waehlen (Index): ");
        int index = sc.nextInt();
        return konten.get(index);
    }
}
