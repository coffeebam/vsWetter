import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRAME0 extends JFrame{

//alle objekte in der UI werden deklariert
    private JPanel panel0;
    private JToolBar bar;
    private JButton leaderboardBtn;
    private JButton overviewBtn;
    private JPanel panel1;

    public FRAME0(){
        //setzt anzeigefläche
        setContentPane(panel0);
        setTitle("vsWetter");
        setLocation(1000, 500);
        setSize(500, 500);

        //programm endet wenn man das fenster schließt
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon mainIcon = new ImageIcon("src/main/resources/Blitz.png");
        setIconImage(mainIcon.getImage());

        //navigationsleist grauer hintergrund
        bar.setBackground(Color.LIGHT_GRAY);
        //knöpfe auf leiste lesbar
        leaderboardBtn.setForeground(Color.BLACK);
        overviewBtn.setForeground(Color.BLACK);

        leaderboardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setVisible(true);
    }


}
