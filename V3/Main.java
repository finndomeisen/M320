package V3;

// Interface für Börsen, was sie können müssen -> preis getten
interface StockExchange {
    // Liefert den Preis einer Aktie
    double getPrice(String stockName);
}

// Börse Zürich, benutzt das interface stockexchange
class ZurichExchange implements StockExchange {

    @Override
    public double getPrice(String stockName) {
        if (stockName.equals("Microsoft")) {
            return 120.00; // Preis in CHF
        }
        return 0.0;
    }
}

// Börse New York
class NewYorkExchange implements StockExchange {

    @Override
    public double getPrice(String stockName) {
        if (stockName.equals("Microsoft")) {
            return 100.00; // Preis in USD
        }
        return 0.0;
    }
}

// Portfolio
class Portfolio {

    private final String stockName;

    public Portfolio(String stockName) {
        this.stockName = stockName;
    }

    // Börse wird als Interface übergeben (Polymorphismus)
    public void printValue(StockExchange exchange) {
        double price = exchange.getPrice(stockName);
        System.out.println(exchange + " " + stockName + " Wert: " + price + "\n");
    }
}

// Testklasse, main
public class Main {
    public static void main(String[] args) {

        // Portfolio mit einer Aktie
        Portfolio portfolio = new Portfolio("Microsoft");

        // Verschiedene Börsen
        StockExchange zurich = new ZurichExchange();
        StockExchange newYork = new NewYorkExchange();

        // Gleiche Methode, andere Börse
        portfolio.printValue(zurich);
        portfolio.printValue(newYork);
    }
}
