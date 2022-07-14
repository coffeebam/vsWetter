import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

import javax.swing.*;

public class PLOTTER extends JPanel {

    @Serial
    private static final long serialVersionUID = 1L;
    private static JFreeChart chart;
    public String datum;


    public PLOTTER() throws IOException, ParseException {
        DefaultCategoryDataset dataset = createDataset();
        chart = ChartFactory.createLineChart("Temperatur Abweichung", "Stunde", "Temperatur in Grad Celsius", dataset);
    }

    //methode für zugriff aus frame0.java
    public JFreeChart getChart() throws IOException, ParseException {
        new PLOTTER();
        return chart;
    }


    Double tempw3Sum = 0.0;
    Double tempMLSum = 0.0;
    Double openweatherSum = 0.0;
    Double rapidweatherSum = 0.0;

    private DefaultCategoryDataset createDataset(){


        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            //daten werden abgefragt
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/resources/testdata.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray forecast = (JSONArray) jsonObject.get("forecasts");
            JSONObject deviationObject = (JSONObject) forecast.get(0);
            JSONArray hourArray = (JSONArray) deviationObject.get("hours");
            this.datum = (String) deviationObject.get("day");
            for (int i = 0; i < hourArray.size(); i++) {
                //loop durch jsonArray und einfügen der daten ins dataset für den chart
                JSONObject hour0 = (JSONObject) hourArray.get(i);
                JSONObject devHour0 = (JSONObject) hour0.get("deviations");
                Double tempw3 = (Double) devHour0.get("tempw3");
                Double tempML = (Double) devHour0.get("tempML");
                Double openweather = (Double) devHour0.get("openweather");
                Double rapidweather = (Double) devHour0.get("rapidweather");
                dataset.addValue(Math.round(tempw3*100.0)/100.0, "tempw3", String.valueOf(i + 1));
                dataset.addValue(Math.round(tempML*100.0)/100.0, "tempML", String.valueOf(i + 1));
                dataset.addValue(Math.round(openweather*100.0)/100.0, "openweather", String.valueOf(i + 1));
                dataset.addValue(Math.round(rapidweather*100.0)/100.0, "rapidweather", String.valueOf(i + 1));
                //berechnung durchschnitt
                tempw3Sum = tempw3Sum + tempw3;
                tempMLSum = tempw3Sum + tempML;
                openweatherSum = openweatherSum + openweather;
                rapidweatherSum = rapidweatherSum + rapidweather;
            }

            tempw3Sum = (double) Math.round((tempw3Sum / 24)*100.0)/100.0;
            tempMLSum = (double) Math.round((tempMLSum / 24)*100.0)/100.0;
            openweatherSum = (double) Math.round((openweatherSum / 24)*100.0)/100.0;
            rapidweatherSum = (double) Math.round((rapidweatherSum / 24)*100.0)/100.0;

        } catch (Exception fe) {
            fe.printStackTrace();
        }

        return dataset;
    }

    public String[][] getTable() {
        String[][] tableInhalt = {
                //tabellen inhalt wird gesetzt und auf zwei nachkommastellen gerundet
                {"0", "tempw3", String.valueOf(Math.round(tempw3Sum*100.0)/100.0)},
                {"0", "tempML", String.valueOf(Math.round(tempMLSum*100.0)/100.0)},
                {"0", "openweather", String.valueOf(Math.round(openweatherSum*100.0)/100.0)},
                {"0", "rapidweather", String.valueOf(Math.round(rapidweatherSum*100.0)/100.0)}
        };
        //tabelle wird sotiert
        Arrays.sort(tableInhalt, Comparator.comparingInt(a -> Integer.parseInt(a[0])));
        //spalte pos wird mit werten belegt
        int j = 1;
        for (int i = 3; i >= 0; i--) {
            tableInhalt[i][0] = j + ".";
            j++;
        }
        return tableInhalt;
    }
}


