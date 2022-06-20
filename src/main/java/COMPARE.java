import java.io.IOException;

public class COMPARE {
    private OPENWEATHERAPI openweather;
    private FORECAST9 weathercom;
    private RAPIDWEATHERAPI weather;
    public void compare() throws IOException, InterruptedException {
        fetchData();


    }
    public void fetchData() throws IOException, InterruptedException { //APIS initialisieren und Daten abfragen

        openweather = new OPENWEATHERAPI();
        openweather.getData();
        //weathercom = new RAPIDWEATHERCOMAPI();
        //weathercom.getData();
        weather = new RAPIDWEATHERAPI();
        weather.getData();
        //System.out.println(new FileInputStream() File("/Users/jonas/IdeaProjects/vsWetter/ressources/apikey.properties").);
    }
}
