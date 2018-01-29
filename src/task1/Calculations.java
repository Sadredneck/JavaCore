package task1;

public class Calculations {
    public static float calculateSquare(Rectagular rectagular) {
        return Math.abs(rectagular.lowRight.x - rectagular.lowLeft.x) * Math.abs(rectagular.topLeft.y - rectagular.lowLeft.y);
    }

    public static float calculateShareSquare(Rectagular rect1, Rectagular rect2) {
        Point lowLeftPoint = null, lowRightPoint = null, topLeftPoint = null, topRightPoint = null;
        if (rect1.lowLeft.x >= rect2.lowLeft.x && rect1.lowLeft.x <= rect2.lowRight.x)
            lowLeftPoint = rect1.lowLeft;
        if (rect1.lowRight.x >= rect2.lowLeft.x && rect1.lowRight.x <= rect2.lowRight.x)
            lowRightPoint = rect1.lowRight;
        if (rect2.lowLeft.x >= rect1.lowLeft.x && rect2.lowLeft.x <= rect1.lowRight.x)
            lowLeftPoint = rect2.lowLeft;
        if (rect2.lowRight.x >= rect1.lowLeft.x && rect2.lowRight.x <= rect1.lowRight.x)
            lowRightPoint = rect2.lowRight;

        if (rect1.lowLeft.y >= rect2.lowLeft.y && rect1.lowLeft.y <= rect2.topLeft.y)
            topLeftPoint = rect1.lowLeft;
        if (rect1.topLeft.y >= rect2.lowLeft.y && rect1.topLeft.y <= rect2.topLeft.y)
            topRightPoint = rect1.lowRight;
        if (rect2.lowLeft.y >= rect1.lowLeft.y && rect2.lowLeft.y <= rect1.topLeft.y)
            topLeftPoint = rect2.lowLeft;
        if (rect2.topLeft.y >= rect1.lowLeft.y && rect2.topLeft.y <= rect1.topLeft.y)
            topRightPoint = rect2.lowRight;

        if (lowLeftPoint == null || lowRightPoint == null || topLeftPoint == null || topRightPoint == null)
            return 0;

        return calculateSquare(new Rectagular(lowLeftPoint, topRightPoint));
    }
}
