import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class MAIN {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, InterruptedException {
        UIManager.setLookAndFeel(new FlatDarculaLaf());
        LAYOUT layout = new LAYOUT();
        //"com.sun.java.swing.plaf.windows.WindowsLookAndFeel"

        layout.nächsteCard();

    }
}
