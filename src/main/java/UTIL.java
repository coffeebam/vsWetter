import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class UTIL {
    public static double fahrenheitToCelsius(double fahrenheit){
    return((fahrenheit-32)*5)/9;
}
public static BigDecimal kelvinToCelsius(BigDecimal kelvin){ //
        int decimals = String.valueOf(kelvin).split("\\.")[1].length(); //Anzahl von Dezimalstellen
    return (kelvin.subtract(BigDecimal.valueOf(273.15))).setScale(decimals, RoundingMode.CEILING); //runde Celsius auf die Anzahl der vorherigen Dezimalstellen.
}
}
