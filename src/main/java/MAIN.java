import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MAIN {

    public MAIN(){
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MAIN m = new MAIN();
        m.fetchData();
    }
    public void fetchData() throws IOException, InterruptedException { //APIS initialisieren und Daten abfragen

        OPENWEATHERAPI openweather = new OPENWEATHERAPI();
        openweather.getData();
        //RAPIDWEATHERCOMAPI weathercom = new RAPIDWEATHERCOMAPI();
        //weathercom.getData();
        //RAPIDWEATHERAPI weather = new RAPIDWEATHERAPI();
        //weather.getData();
        //System.out.println(new FileInputStream() File("/Users/jonas/IdeaProjects/vsWetter/ressources/apikey.properties").);
    }
}
