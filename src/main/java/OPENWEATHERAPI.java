import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class OPENWEATHERAPI extends API_DATA{
    private double maxTemp;
    private double minTemp;
    private double[] temp = new double[24];
    private String location = "München";
    private final static String forecastLink = "https://api.openweathermap.org/data/2.5/onecall";
    private final static String apiKey = UTIL.getKey("openweather");
    public OPENWEATHERAPI() throws IOException, InterruptedException {
        super();
    }

    public JSONObject readJson() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(forecastLink + "?lat=" + getLat() + "&lon=" + getLon() + "&appid="+apiKey))
                /*.header("lat", getLat())
                .header("lon", getLon())
                .header("appid", apiKey)*/
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
        //System.out.println(json.toString());
        int day = 1;
        for(int i = 24; i < 48; i++) {
            temp[i-24] = UTIL.kelvinToCelsius(BigDecimal.valueOf(json.getJSONArray("hourly").getJSONObject(i).getDouble("temp")));
        }
        System.out.println(Arrays.toString(temp));
    }

    public double getMinTemp() {return minTemp;}
    public double getMaxTemp() {return maxTemp;}
}
