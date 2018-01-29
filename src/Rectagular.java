public class Rectagular {
    protected Point lowLeft;
    protected Point lowRight;
    protected Point topLeft;
    protected Point topRight;

    Rectagular(Point lowLeft, Point topRight) {
        this.lowLeft = lowLeft;
        this.lowRight = new Point(topRight.x, lowLeft.y);
        this.topRight = topRight;
        this.topLeft = new Point(lowLeft.x, topRight.y);
    }

    protected void validate() {
    }
}
