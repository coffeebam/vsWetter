import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class PLACEHOLDERAPI extends API_DATA{
    private static final String url = "https://jsonplaceholder.typicode.com/posts/";
    private int temp;
    public PLACEHOLDERAPI() throws IOException, InterruptedException {
        super(url);
    }

    public void getData() throws IOException, InterruptedException {
        JSONArray json = this.readJson();
        this.temp = json.getJSONObject(0).getInt("id");
        System.out.println(temp);
    }
}
