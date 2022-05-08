import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public abstract class API_DATA {
    private double temp;
    private double regenWahrscheinlichkeit;
    private String name;
    private String url;
    private HttpResponse<String> response;
    private JSONArray data;
    private static final String lat = "48.144774";
    private static final String lon = "11.592647";
    public API_DATA(){
    }

    public abstract JSONObject readJson() throws IOException, InterruptedException;
    public double getTemp(){return temp;}
    public double getRegenWahrscheinlichkeit(){return regenWahrscheinlichkeit;}
    public String getName(){return name;}
    public String getUrl(){return url;}
    public String getLat(){return lat;}
    public String getLon(){return lon;}


}
