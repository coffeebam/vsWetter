import java.io.IOException;

public class MAIN {

    public MAIN(){
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MAIN m = new MAIN();
        m.fetchData();
    }
    public void fetchData() throws IOException, InterruptedException { //APIS initialisieren und Daten abfragen
        WETTERCOMAPI wettercom = new WETTERCOMAPI();
        //wettercom.getData();
        OPENWEATHERAPI openweather = new OPENWEATHERAPI();
        openweather.getData();
    }
}
