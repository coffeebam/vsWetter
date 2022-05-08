import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OPENWEATHERAPI extends API_DATA{
    private int temp;
    private String location = "München";
    private final static String forecastLink = "https://pro.openweathermap.org/data/2.5/forecast/hourly";
    private final static String apiKey = "da8131e2cfb98a485a2298b3d16515a4";
    public OPENWEATHERAPI() throws IOException, InterruptedException {
        super();
    }

    @Override
    public JSONObject readJson() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(forecastLink/* + "?lat=" + getLat() + "&lon=" + getLon() + "&appid="+apiKey)*/)) //TODO ugly
                .header("lat", getLat())
                .header("lon", getLon())
                .header("appid", apiKey)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        return new JSONObject(response);
    }

    public static void main(String[] args) throws IOException, InterruptedException {


    }
    public void getData() throws IOException, InterruptedException {
        JSONObject json = this.readJson();
        System.out.println(json);
    }
}
