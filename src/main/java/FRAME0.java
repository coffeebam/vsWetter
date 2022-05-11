import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class FRAME0 extends JFrame{


    private JTabbedPane tabbedPane1;
    private JPanel panel0;
    private JButton button1;

    public FRAME0(){
        setContentPane(panel0);
        setSize(500, 500);
        setLocation(500, 1000);
        setTitle("vsWetter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FRAME0 frame0 = new FRAME0();
        UIManager.setLookAndFeel(new FlatDarkLaf());
    }
}
