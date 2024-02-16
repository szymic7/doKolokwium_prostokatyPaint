package komponenty_swinga;

import elementy_graficzne.Rectangle;
import watki.RectangleThread;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener {

    private JPanel jPanel;
    private MyPanel myPanel;
    private Rectangle currentRectangle;
    private Thread[] threads = new Thread[10];

    public MyFrame() {
        initialize();
    }

    public void initialize() {

        // JFrame
        this.setTitle("Paint - rysowanie prostokątów");
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // JPanel
        jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setFocusable(false);
        jPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.add(jPanel);


        // komponenty_swinga.MyPanel - płótno
        myPanel = new MyPanel();
        myPanel.setBounds(20, 20, myPanel.getWidth(), myPanel.getHeight());
        myPanel.addMouseListener(this);
        jPanel.add(myPanel);

    }


    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        currentRectangle = new Rectangle(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        currentRectangle.setX2Y2(e.getX(), e.getY());

        if (currentRectangle.getX1() < currentRectangle.getX2()) {
            if (currentRectangle.getY1() > currentRectangle.getY2()) { // x1 < x2 & y1 > y2
                currentRectangle.swapYs();
            }
        } else {
            if (currentRectangle.getY1() < currentRectangle.getY2()) { // x1 > x2 & y1 < y2
                currentRectangle.swapXs();
            } else { // x1 > x2 & y1 > y2
                currentRectangle.swapXs();
                currentRectangle.swapYs();
            }
        }


        for(int i = 0; i < myPanel.getSizeOfRectangles(); i++) {
            if(myPanel.getRectangles()[i] == null) {
                myPanel.addRectangle(i, currentRectangle);
                currentRectangle = null;
                myPanel.repaint();
                threads[i] = new RectangleThread(myPanel.getRectangles()[i], myPanel);
                threads[i].start();
                break;
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame().setVisible(true);
            }
        });
    }

}
