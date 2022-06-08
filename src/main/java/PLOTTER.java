import javax.swing.*;
import java.awt.*;

public class PLOTTER extends JPanel {
    public PLOTTER(){

    }

    @Override
    public void paintComponent(Graphics g){
        super.paint(g);
        g.drawLine(0, 0, 100,100);
        g.drawLine(200, 200, 30,30);
    }
}
