import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Konto> konten = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Konto kontoErstellen(String kontoname, Nutzer nutzer) {
        Konto k = new Konto(kontoname, nutzer);
        konten.add(k);
        return k;
    }

    public Konto kontoFinden(String kontoname) {
        for (Konto k : konten) {
            if (k.getKontoname().equals(kontoname)) {
                return k;
            }
        }
        return null;
    }

    public ArrayList<Konto> getKontenVon(Nutzer nutzer) {
        ArrayList<Konto> ergebnis = new ArrayList<>();
        for (Konto k : konten) {
            if (k.getNutzer().equals(nutzer)) {
                ergebnis.add(k);
            }
        }
        return ergebnis;
    }

    public void alleKontenAnzeigen() {
        if (konten.isEmpty()) {
            System.out.println("Keine Konten vorhanden.");
            return;
        }

        for (Konto k : konten) {
            System.out.println("Konto: " + k.getKontoname() +
                    " | Besitzer: " + k.getNutzer().getName() +
                    " | Saldo: " + k.getSaldo());
        }
    }
}
