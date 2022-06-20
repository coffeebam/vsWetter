import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FORECAST9 extends API_DATA{
    private int temp;
    private String location = "München";
    private final static String forecastLink = "https://forecast9.p.rapidapi.com/rapidapi/forecast/";
    private final static String host = "forecast9.p.rapidapi.com";
    private final static String apiKey = UTIL.getKey("forecast9");
    public FORECAST9() throws IOException, InterruptedException {
        super();
    }

    @Override
    public JSONObject readJson() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(forecastLink + location + "/hourly/"))
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
        //JSONObject json = this.readJson();
        JSONObject json = new JSONObject();
        //temp = json.getJSONObject();
    }
}
