package SnakeyArray;

public class Main {
    public static void main(String[] args) {
        int[][] array = new int[9][5];
        Calculate.makeClockwise(array);
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]+"\u0009");
        }
        System.out.println();
        }
    }
}
