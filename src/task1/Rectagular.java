package task1;

public class Rectagular {
    Point lowLeft;
    Point lowRight;
    Point topLeft;
    Point topRight;

    public Rectagular(Point lowLeft, Point topRight) {
        this.lowLeft = lowLeft;
        this.lowRight = new Point(topRight.x, lowLeft.y);
        this.topRight = topRight;
        this.topLeft = new Point(lowLeft.x, topRight.y);
    }

    protected void validate() {
    }
}
