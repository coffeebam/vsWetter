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
        WETTERCOMAPI wettercom = new WETTERCOMAPI();
        wettercom.getData();
        OPENWEATHERAPI openweather = new OPENWEATHERAPI();
        openweather.getData();
    }
}
