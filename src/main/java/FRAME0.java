


import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class FRAME0 extends JFrame{
    private JPanel panel0;
    private JButton overviewBtn;
    private JButton leaderboardBtn;


    public FRAME0(){
        setContentPane(panel0);

        setTitle("vsWetter");
        setSize(500, 500);
        setLocation(1000, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(new FlatDarculaLaf());
        FRAME0 frame0 = new FRAME0();

    }


}
