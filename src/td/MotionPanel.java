package td;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by Virgile on 18/06/2017.
 * TU VOLES TU PAIES
 */
public class MotionPanel extends JPanel{
    private Point initialClick;
    private JFrame parent;
    private ImageIcon iconWallpaper;
    private Image imgWallpaper;

    public MotionPanel(final JFrame parent){
        this.parent = parent;
        this.iconWallpaper = new ImageIcon(getClass().getResource("../img/pokedex.png"));
        this.imgWallpaper = this.iconWallpaper.getImage();

        this.setFocusable(true);
        this.requestFocusInWindow();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if((isBetween(199, 692, initialClick.x)) && (isBetween(2, 38, initialClick.y))) {
                // get location of Window
                int thisX = parent.getLocation().x;
                int thisY = parent.getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
                int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

                // Move window to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                parent.setLocation(X, Y);
            }
            }
        });
    }

    public static boolean isBetween(int a, int b, int c) {
        return b > a ? c > a && c < b : c > b && c < a;
    }

    public void paintComponent (Graphics g) {
        g.drawImage(this.imgWallpaper, 0, 0, null);
    }
}