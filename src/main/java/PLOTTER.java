import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PLOTTER extends JPanel {
    public PLOTTER(){

    }
    int[] bspWerte = {5, 3, 7, 2, 8, 7, 6, 6, 5, 6, 4, 4, 3, 5, 6, 7, 6, 6, 7, 4, 3, 2, 3, 4};
    //int[] bspWerte = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    @Override
    public void paintComponent(@NotNull Graphics g){
        super.paintComponent(g);

        int zero = 0;
        int one = 1;
        for(int i = 0; i + 1< bspWerte.length; i++){
            int x1 = zero*20;
            int y1 = 400 - bspWerte[i] *20;
            int x2 = one * 20;
            int y2 = 400 - bspWerte[i + 1] * 20;

            g.drawLine(x1, y1, x2, y2);

            zero++;
            one++;
        }
    }
}
