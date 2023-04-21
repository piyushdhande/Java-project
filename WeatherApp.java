import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WeatherApp {

    public static void main(String[] args) {
        String apiKey = "2838314557da4f82b00122553232104";
        String location = "New York";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey;
        
        try {
            URL url = new URL(apiUrl);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            String weatherData = sb.toString();
            System.out.println(weatherData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
