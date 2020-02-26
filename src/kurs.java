import java.net.*;
import  java.io.*;

public class kurs {
    public static void main(String[] args) throws IOException {
        String url = "http://www.cbr.ru/scripts/XML_daily.asp";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String curr = "HKD";
        String nominalOpen = "<Nominal>";
        String nominalClose = "</Nominal>";
        String valueOpen = "<Value>";
        String valueClose = "</Value>";

        String nominal = response.substring(response.indexOf(nominalOpen, response.indexOf(curr)) + nominalOpen.length(), response.indexOf(nominalClose, response.indexOf(curr)));
        String value = response.substring(response.indexOf(valueOpen, response.indexOf(curr)) + valueOpen.length(), response.indexOf(valueClose, response.indexOf(curr)));
        System.out.println("Курс: " + nominal + " x " + curr + " = " + value + " RUB.");
    }
}
