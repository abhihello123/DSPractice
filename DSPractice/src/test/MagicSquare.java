package test;

public class MagicSquare {

    static int N = 3;

    // Returns true if mat[][] is magic
    // square, else returns false.
    static boolean isMagicSquare(int mat[][], int row, int col, int size)
    {

        // calculate the sum of
        // the prime diagonal
        int sum = 0,sum2=0;
        for (int i = 0; i < size; i++)
            sum += mat[row+i][col+i];

        // the secondary diagonal
        for (int i = 0; i < size; i++)
            sum2 = sum2 + mat[row+i][col+(size-1-i)];

        if(sum!=sum2)
            return false;

        // For sums of Rows
        for (int i = 0; i < size; i++) {

            int rowSum = 0;
            for (int j = 0; j < size; j++)
                rowSum += mat[row+i][col+j];

            // check if every row sum is
            // equal to prime diagonal sum
            if (rowSum != sum)
                return false;
        }

        // For sums of Columns
        for (int i = 0; i < size; i++) {

            int colSum = 0;
            for (int j = 0; j < size; j++)
                colSum += mat[col+j][row+i];

            // check if every column sum is
            // equal to prime diagonal sum
            if (sum != colSum)
                return false;
        }

        return true;
    }


    static int checkMagicSquare(int mat[][]) {
        int totalRows = mat.length;
        int totalCols = mat[0].length;
        int maxsize = totalRows < totalCols ? totalRows : totalCols;
        //maxsize +=1;
        boolean found = false;
        while (maxsize > 1 && !found) {
            for (int i=0; i<= (totalRows - maxsize) && !found; i++) {
                for (int j=0; (j<= totalCols - maxsize) && !found; j++) {
                    //System.out.println("checking:: " + i + " -- " + j + ";;;;;;;;; maxsize = " + maxsize);
                    found = isMagicSquare(mat, i, j, maxsize);
                }
            }
            //System.out.println("Reducing maxsize");
            if (!found)
                maxsize --;
        }
        if (!found) {
            return 1;
        } else {
            return maxsize;
        }

    }

    // driver program to
    // test above function
    public static void main(String[] args)
    {
        /*int mat[][] = { { 2, 7, 6 },
                        { 9, 5, 1 },
                        { 4, 3, 8 }};*/
        int mat[][] =
                {{7, 2, 4},
                {2, 7, 6},
                {9, 5, 1},
                {4, 3, 8},
                {3, 5, 4}};
        //checkMagicSquare(mat);
        System.out.println(checkMagicSquare(mat));
    }


}
