import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class PLOTTER extends JPanel {
    public PLOTTER(){

    }

    @Override
    public void paintComponent(@NotNull Graphics g){
        super.paintComponent(g);
        g.drawLine(0, 0, 100,100);
        g.drawLine(200, 200, 100,30);
    }

    public static void main(String[] args){
        JFrame test = new JFrame();
        test.setSize(400,400);
        test.setContentPane(new PLOTTER());
        test.setVisible(true);
    }
}
