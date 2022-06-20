import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

public class UTIL {
    public static double fahrenheitToCelsius(double fahrenheit){
    return((fahrenheit-32)*5)/9;
}
public static double kelvinToCelsius(BigDecimal kelvin){ //
        int decimals = String.valueOf(kelvin).split("\\.")[1].length(); //Anzahl von Dezimalstellen
    return (kelvin.subtract(BigDecimal.valueOf(273.15)))
            .setScale(decimals, RoundingMode.CEILING)
            .doubleValue(); //runde Celsius auf die Anzahl der vorherigen Dezimalstellen.
}
public static String getKey(String key) {
    InputStream is = null;
    try {
        Properties prop = new Properties();

        is = new FileInputStream(new File("/Users/jonas/Documents/coding/apikey.properties")
                .toString());
        prop.load(is);
        return prop.getProperty(key);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "fehler";
}


}
