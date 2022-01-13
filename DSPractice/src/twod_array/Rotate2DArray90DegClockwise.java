package twod_array;

public class Rotate2DArray90DegClockwise {

    public static void main(String[] args) {
//        int matrix[][] = { { 1, 2, 3, 4 },
//                { 5, 6, 7, 8 },
//                { 9, 10, 11, 12 },
//                { 13, 14, 15, 16 } };

/*        int matrix[][] = { { 1, 2, 3},
                { 4, 5, 6},
                { 7, 8, 9 } };*/

      /*  int matrix[][] = { { 1, 2, 3},
                { 4, 5, 6},
                { 7, 8, 9 },
                {10, 11, 12}};*/

        int matrix[][] = { { 1, 2, 3, 4},
                { 5, 6, 7, 8},
                { 9, 10, 11, 12 }};

        int[][] arr = copyXthRowIntoN_XColumn(matrix);
        for (int i=0; i< arr.length;i++) {
            for (int j=0; j< arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    private static int[][] copyXthRowIntoN_XColumn(int[][] matrix) {
        int arr[][] = new int[matrix[0].length][matrix.length];
        for (int i=0; i< matrix.length;i++) {
            for (int j=0; j< matrix[i].length; j++) {
                arr[j][matrix.length-1-i] = matrix[i][j];
                System.out.println(String.format("%d %d = %d", j, (matrix.length-1-i), matrix[i][j]));
            }
        }
        return arr;
    }






}
