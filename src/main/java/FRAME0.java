import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRAME0 extends JFrame{

//alle objekte in der UI werden deklariert
    private static FRAME0 frame0;
    private JPanel panel0;
    private JToolBar bar;
    private JButton leaderboardBtn;
    private JButton overviewBtn;
    private JButton weatherBtn;
    private JPanel page;
    private JPanel überblick;
    private JPanel leaderboard;
    private JPanel wetter;
    private JTable table;
    private final Color grau = new Color(60, 63, 65);

    private FRAME0(){
        //setzt anzeigefläche
        setContentPane(panel0);

        Dimension size = new Dimension(500, 500);
        setSize(size);
        setLocation(1000, 500);

        //programm endet wenn man das fenster schließt
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Programmicon
        ImageIcon mainIcon = new ImageIcon("src/main/resources/Blitz.png");
        setIconImage(mainIcon.getImage());

        //navigationsleiste grauer hintergrund
        bar.setBackground(Color.LIGHT_GRAY);

        //knöpfe auf leiste lesbar
        leaderboardBtn.setForeground(Color.BLACK);
        overviewBtn.setForeground(Color.BLACK);
        weatherBtn.setForeground(Color.BLACK);

        //startseite setzen
        überblick.setVisible(true);
        leaderboard.setVisible(false);
        wetter.setVisible(false);

        setVisible(true);
        overviewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                overviewBtn.setBackground(Color.GRAY);
                leaderboardBtn.setBackground(Color.LIGHT_GRAY);
                weatherBtn.setBackground(Color.LIGHT_GRAY);
                überblick.setVisible(true);
                leaderboard.setVisible(false);
                wetter.setVisible(false);
            }
        });

        //alles für das leaderboard
        leaderboardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                overviewBtn.setBackground(Color.LIGHT_GRAY);
                leaderboardBtn.setBackground(Color.GRAY);
                weatherBtn.setBackground(Color.LIGHT_GRAY);
                überblick.setVisible(false);
                leaderboard.setVisible(true);
                wetter.setVisible(false);
            }
        });
        //erstellt Tabelle
        //createUIComponents();
        //table.setVisible(true);


        weatherBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                overviewBtn.setBackground(Color.LIGHT_GRAY);
                leaderboardBtn.setBackground(Color.LIGHT_GRAY);
                weatherBtn.setBackground(Color.GRAY);
                überblick.setVisible(false);
                leaderboard.setVisible(false);
                wetter.setVisible(true);
            }
        });
    }

    public static FRAME0 getFrame0(){
        if(frame0 == null){
            frame0 = new FRAME0();
        }
        return frame0;
    }


    private void createUIComponents() {
        String[][] tableInhalt = {
                {"1.", "[bsp] openweather.com"},
                {"2.", "[bsp] rapidweather.com"}
        };
        String[] kopfzeile = {"Pos", "Anbieter"};
        table = new JTable(tableInhalt, kopfzeile) {
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        Font font = new Font("Arial Black", Font.PLAIN, 13);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(font);
        tableHeader.setBackground(grau);
        tableHeader.setForeground(Color.LIGHT_GRAY);
        table.getColumn("Pos").setMaxWidth(50);
        table.setGridColor(Color.DARK_GRAY);

    }



}
