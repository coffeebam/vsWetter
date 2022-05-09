import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RAPIDWEATHERAPI extends API_DATA{
    private double[] temp = new double[24];
    private String location = "München";
    private final static String forecastLink = "https://weatherapi-com.p.rapidapi.com/forecast.json?q=";
    private final static String host = "weatherapi-com.p.rapidapi.com";
    private final static String apiKey = UTIL.getKey("rapidweather");
    public RAPIDWEATHERAPI() throws IOException, InterruptedException {
        super();
    }

    @Override
    public JSONObject readJson() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(forecastLink + location + "&days=3"))
                .header("X-RapidAPI-Host", host)
                .header("X-RapidAPI-Key", apiKey)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        return new JSONObject(response.body());
    }

    public static void main(String[] args) throws IOException, InterruptedException {


    }
    public void getData() throws IOException, InterruptedException {
        JSONObject json = this.readJson();
        System.out.println(json);
        int day = 1;
        for(int i = 0; i < 24; i++) {
            temp[i] = json.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(day).getJSONArray("hour").getJSONObject(i).getDouble("temp_c"); //Temperatur vom nächsten TAg.
            System.out.println(temp[i]);
        }

    }
}
