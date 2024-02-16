package elementy_graficzne;

public class Rectangle {
    private int x1, y1, x2, y2;

    public Rectangle(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    public void setX2Y2(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return this.x1;
    }

    public int getY1() {
        return this.y1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY2() {
        return this.y2;
    }

    public int getWidth() {
        return Math.abs(this.x2 - this.x1);
    }

    public int getHeight() {
        return Math.abs(this.y2 - this.y1);
    }

    public void swapXs() {
        int x = this.x1;
        this.x1 = this.x2;
        this.x2 = x;
    }

    public void swapYs() {
        int y = this.y1;
        this.y1 = this.y2;
        this.y2 = y;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

}
