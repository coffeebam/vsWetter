import java.io.FileNotFoundException;
import java.io.FileReader;


import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

import javax.swing.*;

public class PLOTTER extends JPanel {

    private static final long serialVersionUID = 1L;
    private static JFreeChart chart;
    public String datum;


    public PLOTTER() throws IOException, ParseException {

        DefaultCategoryDataset dataset = createDataset();
        this.chart = ChartFactory.createLineChart("Temperatur Abweichung", "Stunde", "Temperatur in Grad Celsius", dataset);
    }


    public JFreeChart getChart() throws IOException, ParseException {
        new PLOTTER();
        return this.chart;
    }

    //https://www.javatpoint.com/jfreechart-line-chart
    Double tempw3Sum = 0.0;
    Double tempMLSum = 0.0;
    Double openweatherSum = 0.0;
    Double rapidweatherSum = 0.0;

    private DefaultCategoryDataset createDataset() throws IOException, ParseException {



        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        /*
        dataset.addValue(5, name, "1.7.");
        dataset.addValue(3, name, "2.7.");
        dataset.addValue(4, name, "3.7.");
        dataset.addValue(5, name, "4.7.");
        dataset.addValue(5, name, "5.7.");
        dataset.addValue(7, name, "6.7.");
        dataset.addValue(5, name, "7.7.");
        dataset.addValue(5, name, "8.7.");
        dataset.addValue(5, name, "9.7.");
        dataset.addValue(5, name, "10.7.");
        dataset.addValue(5, name, "11.7.");
        dataset.addValue(5, name, "12.7.");


        dataset.addValue(4, name1, "1.7.");
        dataset.addValue(6, name1, "2.7.");
        dataset.addValue(7, name1, "3.7.");
        dataset.addValue(3, name1, "4.7.");
        dataset.addValue(2, name1, "5.7.");
        dataset.addValue(1, name1, "6.7.");
        dataset.addValue(3, name1, "7.7.");
        dataset.addValue(4, name1, "7.7.");
        dataset.addValue(3, name1, "6.7.");
        dataset.addValue(3, name1, "5.7.");


         */


        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/resources/testdata.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray forecast = (JSONArray) jsonObject.get("forecasts");
            JSONObject deviationObject = (JSONObject) forecast.get(0);
            JSONArray hourArray = (JSONArray) deviationObject.get("hours");
            this.datum = (String) deviationObject.get("day");
            for(int i = 0; i < hourArray.size(); i++) {
                JSONObject hour0 = (JSONObject) hourArray.get(i);
                JSONObject devHour0 = (JSONObject) hour0.get("deviations");
                Double tempw3 = (Double) devHour0.get("tempw3");
                Double tempML = (Double) devHour0.get("tempML");
                Double openweather = (Double) devHour0.get("openweather");
                Double rapidweather = (Double) devHour0.get("rapidweather");
                dataset.addValue(tempw3, "tempw3", String.valueOf(i+1));
                dataset.addValue(tempML, "tempML", String.valueOf(i+1));
                dataset.addValue(openweather, "openweather", String.valueOf(i+1));
                dataset.addValue(rapidweather, "rapidweather", String.valueOf(i+1));
                tempw3Sum = tempw3Sum + tempw3;
                tempMLSum = tempw3Sum + tempML;
                openweatherSum = openweatherSum + openweather;
                rapidweatherSum = rapidweatherSum + rapidweather;


            }

            tempw3Sum = tempw3Sum/24;
            tempMLSum = tempMLSum/24;
            openweatherSum = openweatherSum/24;
            rapidweatherSum = rapidweatherSum/24;

        }

        catch(FileNotFoundException fe)
            {
                fe.printStackTrace();
            }
        catch(Exception e)
            {
                e.printStackTrace();
            }

        return dataset;
    }

    public String[][] getTable(){
        String[][] tableInhalt = {
                {"0","tempw3",String.valueOf(tempw3Sum)},
                {"0","tempML",String.valueOf(tempMLSum)},
                {"0","openweather",String.valueOf(openweatherSum)},
                {"0","rapidweather",String.valueOf(rapidweatherSum)}
        };
        Arrays.sort(tableInhalt, Comparator.comparingInt(a -> Integer.parseInt(a[0])));

        for(int i = 0; i < 4; i++){
            tableInhalt[i][0] = String.valueOf(i+1) + ".";
        }
        return tableInhalt;
    }

    public static void main(String[] args) throws IOException, ParseException {
        PLOTTER plotter = new PLOTTER();
    }

}
