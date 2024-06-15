package Task4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter the currency code to convert from (e.g., USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the currency code to convert to (e.g., EUR): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);

        if (convertedAmount != -1) {
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(amount + " " + fromCurrency + " = " +
                    df.format(convertedAmount) + " " + toCurrency);
        } else {
            System.out.println("Currency conversion failed.");
        }

        scanner.close();
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        String apiKey = "YOUR_API_KEY"; // Replace with your API key
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + fromCurrency;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject();
            JSONObject rates = jsonResponse.getJSONObject("rates");
            double exchangeRate = rates.getDouble(toCurrency);

            return amount * exchangeRate;

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
