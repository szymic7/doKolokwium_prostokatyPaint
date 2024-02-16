package komponenty_swinga;

import elementy_graficzne.Rectangle;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyPanel extends JPanel {

    private Rectangle[] rectangles = new Rectangle[10];

    public MyPanel() {
        initialize();
    }

    public void initialize() {
        this.setBackground(new Color(231, 219, 205));
        this.setBorder(new LineBorder(Color.BLACK, 3, true));
        this.setSize(new Dimension(800, 600));
        this.setLayout(null);
        this.setFocusable(false);
    }

    public void addRectangle(int i, Rectangle r) {
        //rectangles.add(r);
        rectangles[i] = r;
    }

    public Rectangle[] getRectangles() {
        return rectangles;
    }

    public int getSizeOfRectangles() {
        return rectangles.length;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        try {
            g2d.setColor(new Color(199, 53, 53));
            for(Rectangle r: rectangles) {
                if(r != null) {
                    g2d.drawRect(r.getX1(), r.getY1(), r.getWidth(), r.getHeight());
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
