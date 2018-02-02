package task1.squares;

public class Rectagular {
    private Point lowLeft;
    private Point lowRight;
    private Point topLeft;
    private Point topRight;

    public Rectagular(Point lowLeft, Point topRight) {
        this.lowLeft = new Point(Math.min(topRight.x, lowLeft.x),
                Math.min(topRight.y, lowLeft.y));
        this.lowRight = new Point(Math.max(topRight.x, lowLeft.x),
                Math.min(topRight.y, lowLeft.y));
        this.topRight = new Point(Math.max(topRight.x, lowLeft.x),
                Math.max(topRight.y, lowLeft.y));
        this.topLeft = new Point(Math.min(topRight.x, lowLeft.x),
                Math.max(topRight.y, lowLeft.y));
    }

    public float calculateSpace() {
        return Math.abs(lowRight.x - lowLeft.x) * Math.abs(topLeft.y - lowLeft.y);
    }

    public float calculateCommonSpace(Rectagular rect) {
        Point lowLeftPoint = null, lowRightPoint = null, topLeftPoint = null, topRightPoint = null;
        if (lowLeft.x >= rect.lowLeft.x
                && lowLeft.x <= rect.lowRight.x)
            lowLeftPoint = lowLeft;
        if (lowRight.x >= rect.lowLeft.x
                && lowRight.x <= rect.lowRight.x)
            lowRightPoint = lowRight;
        if (rect.lowLeft.x >= lowLeft.x
                && rect.lowLeft.x <= lowRight.x)
            lowLeftPoint = rect.lowLeft;
        if (rect.lowRight.x >= lowLeft.x
                && rect.lowRight.x <= lowRight.x)
            lowRightPoint = rect.lowRight;

        if (lowLeft.y >= rect.lowLeft.y
                && lowLeft.y <= rect.topLeft.y)
            topLeftPoint = lowLeft;
        if (topLeft.y >= rect.lowLeft.y
                && topLeft.y <= rect.topLeft.y)
            topRightPoint = lowRight;
        if (rect.lowLeft.y >= lowLeft.y
                && rect.lowLeft.y <= topLeft.y)
            topLeftPoint = rect.lowLeft;
        if (rect.topLeft.y >= lowLeft.y
                && rect.topLeft.y <= topLeft.y)
            topRightPoint = rect.lowRight;

        if (lowLeftPoint == null || lowRightPoint == null || topLeftPoint == null || topRightPoint == null)
            return 0;

        return new Rectagular(lowLeftPoint, topRightPoint).calculateSpace();
    }

    protected void validate() {

    }
}
