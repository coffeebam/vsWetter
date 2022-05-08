import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.*;
import java.net.URL;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public abstract class API_DATA {
    private double temp;
    private double regenWahrscheinlichkeit;
    private String name;
    private String url;
    private HttpResponse<String> response;
    private JSONArray data;
    public API_DATA(String u) throws IOException, InterruptedException {
        this.url = u;
    }

    public JSONArray readJson() throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            for (String line = null; (line = rd.readLine()) != null; ) {
                builder.append(line).append("\n");
            }
            JSONTokener tokener = new JSONTokener(builder.toString());
            return new JSONArray(tokener);
        }
        finally {
            is.close();
        }
    }
    public double getTemp(){return temp;}
    public double getRegenWahrscheinlichkeit(){return regenWahrscheinlichkeit;}
    public String getName(){return name;}
    public String getUrl(){return url;}


}
