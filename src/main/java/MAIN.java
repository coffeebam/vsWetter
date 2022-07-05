import com.formdev.flatlaf.FlatDarculaLaf;
import com.orsoncharts.util.json.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MAIN {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, ParseException, org.json.simple.parser.ParseException {
        UIManager.setLookAndFeel(new FlatDarculaLaf());
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        FRAME0 frame0 = FRAME0.getFrame0();
        //"com.sun.java.swing.plaf.windows.WindowsLookAndFeel"


    }
}
