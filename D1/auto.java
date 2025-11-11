public class auto {
    // Attribute (gekapselt)
    private String farbe;
    private int geschwindigkeit;

    // Konstruktor
    public auto(String farbe, int geschwindigkeit) {
        this.farbe = farbe;
        this.geschwindigkeit = geschwindigkeit;
    }

    // Getter und Setter
    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    // Methode zum Beschleunigen (ändert Zustand)
    public void beschleunigen(int wert) {
        geschwindigkeit += wert;
        System.out.println(farbe + "es Auto beschleunigt auf " + geschwindigkeit + " km/h.");
    }

    // Methode zum Abbremsen (ändert Zustand)
    public void bremsen(int wert) {
        geschwindigkeit -= wert;
        if (geschwindigkeit < 0) geschwindigkeit = 0;
        System.out.println(farbe + "es Auto bremst auf " + geschwindigkeit + " km/h.");
    }

    // Methode für Kommunikation zwischen Objekten
    public void rennenMit(auto gegner) {
        System.out.println(farbe + "es Auto fährt ein Rennen gegen das " + gegner.getFarbe() + "e Auto!");
        if (this.geschwindigkeit > gegner.getGeschwindigkeit()) {
            System.out.println(farbe + "es Auto gewinnt!");
        } else if (this.geschwindigkeit < gegner.getGeschwindigkeit()) {
            System.out.println(gegner.getFarbe() + "es Auto gewinnt!");
        } else {
            System.out.println("Unentschieden!");
        }
    }
}

