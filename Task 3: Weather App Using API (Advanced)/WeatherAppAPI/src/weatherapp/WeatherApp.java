package weatherapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;


public class WeatherApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();
        scanner.close();

        String apiKey = "0b0ec52325eb62561637e0052f5e85e7";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

        try {
            // Create URL connection
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read API response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder jsonResponse = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                jsonResponse.append(inputLine);
            }
            in.close();

            // Parse JSON data
            JSONObject obj = new JSONObject(jsonResponse.toString());
            String cityName = obj.getString("name");
            double temperature = obj.getJSONObject("main").getDouble("temp");
            int humidity = obj.getJSONObject("main").getInt("humidity");

            // Display output
            System.out.println("\nWeather Report:");
            System.out.println("City: " + cityName);
            System.out.println("Temperature: " + temperature + "°C");
            System.out.println("Humidity: " + humidity + "%");

        } catch (Exception e) {
            System.out.println("Error: City not found or something went wrong.");
        }
    }
}
