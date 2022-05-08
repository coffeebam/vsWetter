import org.json.JSONObject;

import java.io.IOException;
import java.net.http.HttpResponse;

public class MAIN {
    private HttpResponse<String> response;

    public MAIN() throws IOException, InterruptedException {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MAIN m = new MAIN();
        m.fetchData();
    }
    public void fetchData() throws IOException, InterruptedException {
        PLACEHOLDERAPI placeholderapi = new PLACEHOLDERAPI();
        placeholderapi.getData();
    }
}
