package watki;

import elementy_graficzne.Rectangle;
import komponenty_swinga.MyPanel;

public class RectangleThread extends Thread {

    private Rectangle r;
    private MyPanel myPanel;
    public RectangleThread(Rectangle r, MyPanel myPanel) {
        this.r = r;
        this.myPanel = myPanel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(30);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (r.getX2() < 800) {
                r.setX1(r.getX1() + 10);
                r.setX2(r.getX2() + 10);
                myPanel.repaint();
            } else {
                r.setX2(r.getWidth());
                r.setX1(0);
            }
        }
    }
}
