import task1.squares.Point;
import task1.squares.Rectagular;

public class Main {

    public static void main(String[] args) {
        doTask1(new Point(0,0),new Point(1,0));

        doTask2(new Rectagular(new Point(-1, -1), new Point(1, 1)),
                new Rectagular(new Point(0, 0), new Point(2, 2)));
        doTask2(new Rectagular(new Point(-1, -1), new Point(1, 1)),
                new Rectagular(new Point(2, 2), new Point(3, 3)));
    }

    static void doTask1(Point point1, Point point2) {
        Rectagular sampleRect = new Rectagular(point1, point2);
        System.out.println(sampleRect.calculateSpace());
    }

    static void doTask2(Rectagular rectagular1, Rectagular rectagular2) {
        System.out.println(rectagular1.calculateCommonSpace(rectagular2));
    }
}
