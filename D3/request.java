package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import org.json.JSONObject; // Wird durch Maven bereitgestellt

public class Request {

    protected URL url;

    public void setUrl(String seturl) {
        try {
            URI uri = URI.create(seturl);
            this.url = uri.toURL();
        } catch (Exception e) {
            System.err.println("Ungültige URL: " + e.getMessage());
        }
    }

    public void buildconnection() {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
            );

            StringBuilder responseText = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseText.append(line);
            }
            reader.close();

            // DELEGATION: Wir übergeben den Text an eine spezialisierte Logik-Methode
            verarbeiteDaten(responseText.toString());

        } catch (Exception e) {
            // EXCEPTION HANDLING: Fehler abfangen (Lernziel D3)
            System.err.println("Verbindungsfehler: " + e.getMessage());
        }
    }

    // REINE LOGIK-METHODE (Trennung von Infrastruktur und Logik)
    private void verarbeiteDaten(String jsonRaw) {
        try {
            // Delegation an die Library: Kein Regex nötig!
            JSONObject json = new JSONObject(jsonRaw);
            
            if (json.has("name")) {
                String name = json.getString("name");
                System.out.println("Pokemon Name: " + name);
            } else {
                System.out.println("Kein Pokemon gefunden.");
            }
        } catch (Exception e) {
            System.err.println("Fehler beim Parsen der Daten: " + e.getMessage());
        }
    }
}
