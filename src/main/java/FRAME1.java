import javax.swing.*;
import javax.swing.table.TableColumn;

public class FRAME1 extends JFrame {
    private JPanel panel1;
    private JTable leaderboard;

    public FRAME1(){
        setContentPane(panel1);
        leaderboard.addColumn(new TableColumn(1, 50));
        setVisible(true);
    }

    public JPanel getPanel1(){
        return panel1;
    }
}
