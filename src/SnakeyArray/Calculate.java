package SnakeyArray;

public class Calculate {
    private enum Direction {LEFT, RIGHT, UP, DOWN}

    public static void makeClockwise(int[][] array) {
        if (array == null)
            return;
        int leftEdge = 0,
                rightEdge = array[0].length - 1,
                topEdge = 0,
                bottomEdge = array.length - 1,
                x = 0, y = 0;
        Direction direction = Direction.RIGHT;

        for (int i = 1; i <= array.length * array[0].length; i++) {
            array[y][x] = i;
            switch (direction) {
                case UP:
                    if (y == topEdge) {
                        direction = Direction.RIGHT;
                        x++;
                        leftEdge++;
                    }
                    else {
                        y--;
                    }
                    break;
                case DOWN:
                    if (y == bottomEdge) {
                        direction = Direction.LEFT;
                        x--;
                        rightEdge--;
                    }
                    else {
                        y++;
                    }
                    break;
                case LEFT:
                    if (x == leftEdge) {
                        direction = Direction.UP;
                        y--;
                        bottomEdge--;
                    }
                    else {
                        x--;
                    }
                    break;
                case RIGHT:
                    if (x == rightEdge) {
                        direction = Direction.DOWN;
                        y++;
                        topEdge++;
                    }
                    else {
                        x++;
                    }
                    break;
            }
        }
    }
}
