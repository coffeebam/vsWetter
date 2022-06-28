import java.awt.*;

import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;

import javax.swing.*;

public class PLOTTER extends JPanel {

    private static final long serialVersionUID = 1L;
    private static JFreeChart chart;

    public PLOTTER(){

        DefaultCategoryDataset dataset = createDataset();
        this.chart = ChartFactory.createLineChart("Temperatur Abweichung", "Datum", "Temperatur in Grad Celsius", dataset);
    }



    public  JFreeChart getChart(){
        new PLOTTER();
        return this.chart;
    }

    //https://www.javatpoint.com/jfreechart-line-chart

    private DefaultCategoryDataset createDataset(){

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

        return dataset;
    }


}
