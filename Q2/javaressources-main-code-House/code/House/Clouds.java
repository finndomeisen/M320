/**
 * Clouds let you display clouds with an animation
 *
 * @author: Finn Aidan Carl Domeisen
 * @author: Beda Valon Brunner
 *
 * @version 2025.12.16
 */
public class Clouds {
    private Circle c1;
    private Circle c2;
    private Circle c3;
    private Circle c4;
    private Circle c5;
    private Circle c6;
    private Circle c7;
    private Circle c8;

    public Clouds() {
        // Alle Wolken-Kreise erstellen
        c1 = new Circle();
        c2 = new Circle();
        c3 = new Circle();
        c4 = new Circle();
        c5 = new Circle();
        c6 = new Circle();
        c7 = new Circle();
        c8 = new Circle();

        // Positionen und Farben setzen (Beispielwerte)
        c1.changeSize(40);
        c2.changeSize(50);
        c3.changeSize(35);
        c4.changeSize(45);
        c5.changeSize(40);
        c6.changeSize(50);
        c7.changeSize(35);
        c8.changeSize(45);

        c1.changeColor("blue");
        c2.changeColor("blue");
        c3.changeColor("blue");
        c4.changeColor("blue");
        c5.changeColor("blue");
        c6.changeColor("blue");
        c7.changeColor("blue");
        c8.changeColor("blue");

        // Startpositionen (kannst du anpassen)
        c1.moveHorizontal(20);  c1.moveVertical(20);
        c2.moveHorizontal(50);  c2.moveVertical(10);
        c3.moveHorizontal(80);  c3.moveVertical(20);
        c4.moveHorizontal(110); c4.moveVertical(10);

        c5.moveHorizontal(200); c5.moveVertical(30);
        c6.moveHorizontal(230); c6.moveVertical(20);
        c7.moveHorizontal(260); c7.moveVertical(30);
        c8.moveHorizontal(290); c8.moveVertical(20);
    }

    public void makeVisible() {
        c1.makeVisible();
        c2.makeVisible();
        c3.makeVisible();
        c4.makeVisible();
        c5.makeVisible();
        c6.makeVisible();
        c7.makeVisible();
        c8.makeVisible();
    }

    public void moveHorizontal(int distance) {
        c1.moveHorizontal(distance);
        c2.moveHorizontal(distance);
        c3.moveHorizontal(distance);
        c4.moveHorizontal(distance);
        c5.moveHorizontal(distance);
        c6.moveHorizontal(distance);
        c7.moveHorizontal(distance);
        c8.moveHorizontal(distance);
    }

    public void moveVertical(int distance) {
        c1.moveVertical(distance);
        c2.moveVertical(distance);
        c3.moveVertical(distance);
        c4.moveVertical(distance);
        c5.moveVertical(distance);
        c6.moveVertical(distance);
        c7.moveVertical(distance);
        c8.moveVertical(distance);
    }
    
    /**
     * Animation for clouds
     * <p>
     * Clouds fly from left to right
     * </p>
    **/
    public void animateClouds() {
        for (int i = 0; i < 200; i++) {
            moveHorizontal(5);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
