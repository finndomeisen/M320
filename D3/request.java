package D3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class request {

    protected URL url;
    protected HttpURLConnection connection;

    public void setUrl(String seturl) {
        try {
            URI uri = URI.create(seturl);
            this.url = uri.toURL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildconnection() {
        try {
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(stream)
            );

            StringBuilder jsonText = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }

            reader.close();

            String json = jsonText.toString();

            Pattern pattern = Pattern.compile(
              "\"id\"\\s*:\\s*\\d+.*?\"name\"\\s*:\\s*\"([^\"]+)\"",
              Pattern.DOTALL
            );

            Matcher matcher = pattern.matcher(json);

            if (matcher.find()) {
                System.out.println("Pokemon Name: " + matcher.group(1));
            } else {
                System.out.println("Kein Pokemon gefunden");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
