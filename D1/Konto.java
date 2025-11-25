public class Konto {
    private String kontoname;
    private double saldo;
    private Nutzer nutzer;

    public Konto(String kontoname, Nutzer nutzer) {
        this.kontoname = kontoname;
        this.nutzer = nutzer;
        this.saldo = 0;
    }

    public String getKontoname() {
        return kontoname;
    }

    public double getSaldo() {
        return saldo;
    }

    public Nutzer getNutzer() {
        return nutzer;
    }

    public void einzahlen(double betrag) {
        saldo += betrag;
    }

    public boolean abheben(double betrag) {
        if (betrag > saldo) {
            return false;
        }
        saldo -= betrag;
        return true;
    }
}
