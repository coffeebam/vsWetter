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

    public PLOTTER() throws IOException, ParseException {

        DefaultCategoryDataset dataset = createDataset();
        this.chart = ChartFactory.createLineChart("Temperatur Abweichung", "Datum", "Temperatur in Grad Celsius", dataset);
    }



    public JFreeChart getChart() throws IOException, ParseException {
        new PLOTTER();
        return this.chart;
    }

    //https://www.javatpoint.com/jfreechart-line-chart

    private DefaultCategoryDataset createDataset() throws IOException, ParseException {

        String name = "test";
        String name1 = "test1";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

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

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/resources/testdata.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray deviationArray = (JSONArray) jsonObject.get("hours");
            Double deviation = (Double) deviationArray.get(0);
            System.out.println(deviation);
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

    public static void main(String[] args) throws IOException, ParseException {
        PLOTTER plotter = new PLOTTER();
    }

}
