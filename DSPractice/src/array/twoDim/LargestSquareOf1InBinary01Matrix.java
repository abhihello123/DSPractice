package array.twoDim;

import java.util.HashMap;
import java.util.Map;

public class LargestSquareOf1InBinary01Matrix {

    Map<String, Integer> valueMap = new HashMap<>();
    int largest=0;
    public static void main(String[] args) {
        int matrix[][] = {
                {1,1,1,1,1},
                {0,1,1,1,1},
                {1,1,1,1,1},
                {0,1,1,1,1}
        };
        LargestSquareOf1InBinary01Matrix obj = new LargestSquareOf1InBinary01Matrix();
        obj.findLargestMatrixOf1(matrix, 0, 0);
        System.out.println(obj.valueMap);
        System.out.println(obj.largest);
    }

    private int findLargestMatrixOf1(int[][] matrix, int row, int col) {
        if (matrix[row][col] == 0) return 0;
        String key = String.format("%d-%d",row,col);
        if (valueMap.containsKey(key)) return valueMap.get(key);
        if ((row == matrix.length - 1) ||
                (col == matrix[row].length -1)) {
            if (matrix[row][col] > largest) largest = matrix[row][col];
            return matrix[row][col];
        }
        int largestMatrixSize = returnMinimumOf3(
                findLargestMatrixOf1(matrix, row, col+1),
                findLargestMatrixOf1(matrix, row+1, col),
                findLargestMatrixOf1(matrix, row+1, col+1)) + 1;
        if (largestMatrixSize > largest) largest = largestMatrixSize;
        valueMap.put(key, largestMatrixSize);
        return largestMatrixSize;
    }

    private int returnMinimumOf3(int a, int b, int c) {
        int min = a;
        if (b<=a && b<=c) min = b;
        if (c<=a && c<=b) min = c;
        return  min;
    }


}
