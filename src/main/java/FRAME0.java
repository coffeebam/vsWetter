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
    private JButton weatherBtn;

    public FRAME0(){
        //setzt anzeigefläche
        setContentPane(panel0);

        setLocation(1000, 500);

        //programm endet wenn man das fenster schließt
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Programmicon
        ImageIcon mainIcon = new ImageIcon("src/main/resources/Blitz.png");
        setIconImage(mainIcon.getImage());

        //navigationsleist grauer hintergrund
        bar.setBackground(Color.LIGHT_GRAY);

        //knöpfe auf leiste lesbar
        leaderboardBtn.setForeground(Color.BLACK);
        overviewBtn.setForeground(Color.BLACK);
        weatherBtn.setForeground(Color.BLACK);

        leaderboardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setVisible(true);
    }

    public JPanel getPanel0(){
        return panel0;
    }


}
