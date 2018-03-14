package snakeyarray;

public class Calculate {
    private enum Direction {LEFT, RIGHT, UP, DOWN}

    public static int[][] makeClockwise(int height, int width) {
        if (height < 1 || width < 1)
            return null;
        int[][] array = new int[height][width];
        int leftEdge = 0,
                rightEdge = width - 1,
                topEdge = 0,
                bottomEdge = height - 1,
                x = 0, y = 0;
        Direction direction = Direction.RIGHT;

        for (int i = 1; i <= height * width; i++) {
            array[y][x] = i;
            switch (direction) {
                case UP:
                    if (y == topEdge) {
                        direction = Direction.RIGHT;
                        x++;
                        leftEdge++;
                    } else {
                        y--;
                    }
                    break;
                case DOWN:
                    if (y == bottomEdge) {
                        direction = Direction.LEFT;
                        x--;
                        rightEdge--;
                    } else {
                        y++;
                    }
                    break;
                case LEFT:
                    if (x == leftEdge) {
                        direction = Direction.UP;
                        y--;
                        bottomEdge--;
                    } else {
                        x--;
                    }
                    break;
                case RIGHT:
                    if (x == rightEdge) {
                        direction = Direction.DOWN;
                        y++;
                        topEdge++;
                    } else {
                        x++;
                    }
                    break;
            }
        }
        return array;
    }

    public static int[][] makeUnclockwise(int height, int width) {
        if (height < 1 || width < 1)
            return null;
        int[][] array = new int[height][width];
        int leftEdge = 0,
                rightEdge = width - 1,
                topEdge = 0,
                bottomEdge = height - 1,
                x = width - 1, y = 0;
        Direction direction = Direction.LEFT;

        for (int i = 1; i <= height * width; i++) {
            array[y][x] = i;
            switch (direction) {
                case UP:
                    if (y == topEdge) {
                        direction = Direction.LEFT;
                        x--;
                        rightEdge--;
                    } else {
                        y--;
                    }
                    break;
                case DOWN:
                    if (y == bottomEdge) {
                        direction = Direction.RIGHT;
                        x++;
                        leftEdge++;
                    } else {
                        y++;
                    }
                    break;
                case LEFT:
                    if (x == leftEdge) {
                        direction = Direction.DOWN;
                        y++;
                        topEdge++;
                    } else {
                        x--;
                    }
                    break;
                case RIGHT:
                    if (x == rightEdge) {
                        direction = Direction.UP;
                        y--;
                        bottomEdge--;
                    } else {
                        x++;
                    }
                    break;
            }
        }
        return array;
    }
}
