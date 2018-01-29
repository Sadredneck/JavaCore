
public class Main {

    public static void main(String[] args) {
        doTask1(new Point(0,0),new Point(1,0));

        doTask2(new Rectagular(new Point(-1, -1), new Point(1, 1)),
                new Rectagular(new Point(0, 0), new Point(2, 2)));
        doTask2(new Rectagular(new Point(-1, -1), new Point(1, 1)),
                new Rectagular(new Point(2, 2), new Point(3, 3)));
    }

    public static void doTask1(Point point1, Point point2) {
        Rectagular sampleRect = new Rectagular(point1, point2);
        float square = Calculations.calculateSquare(sampleRect);
        System.out.println(square);
    }

    public static void doTask2(Rectagular rectagular1, Rectagular rectagular2) {
        float square = Calculations.calculateShareSquare(rectagular1, rectagular2);
        System.out.println(square);
    }
}
