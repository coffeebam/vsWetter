import javax.swing.*;
import java.awt.*;


public class LAYOUT extends CardLayout {

    private Container container;
    private CardLayout card;
    private FRAME0 frame0;
    private FRAME1 frame1;

    public LAYOUT(){
        this.container = new Container();

        card = new CardLayout();
        container.setLayout(card);
        layoutContainer(container);

        frame0 = new FRAME0();
        frame1 = new FRAME1();

        container.add("Überblick", frame0.getPanel0());
        container.add("Leaderboard", frame1.getPanel1());

        Dimension size = new Dimension(500, 500);
        container.setPreferredSize(size);
    }

    public void nächsteCard(){
        next(frame0.getPanel0());
    }
}
