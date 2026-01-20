# 2D Abfahrtsspiel

Ein einfaches 2D-Abfahrtsspiel in Java mit Swing.

## Spielweise

- **Pfeiltaste Links/Rechts**: Spieler nach links/rechts bewegen
- **Leertaste**: Springen
- **R**: Spiel neu starten (nach Game Over)

## Ziel

Weiche den schwarzen Hindernissen aus, die von oben kommen.
Mit jedem Hindernis, das du vermeidest, steigt dein Score um 10 Punkte.

## Steuerung

- Der Spieler wird als rotes Quadrat dargestellt
- Die Hindernisse sind schwarze Rechtecke
- Der Score wird oben links angezeigt

## Kompilieren und Ausführen

```bash
javac -d target/classes src/main/java/ch/tbz/downhill/*.java src/main/java/ch/tbz/downhill/*/*.java
java -cp target/classes ch.tbz.downhill.Main
```
