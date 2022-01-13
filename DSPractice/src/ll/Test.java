package ll;

public class Test {
/*
        1 2 3
        4 5 6
        7 8 9

        7 4 1
        8 5 2
        9 6 3
        */
/*

    1  4  7 10 12   12 10 7 4 1
    2  5  8
    3  6  9
*/


    void rotateMatrixBy90Degrees(int[][] a) {
        int dim = a.length;
        //swap row,col values
        for (int i =0; i< a.length; i++) {
            for (int j =0; j< a[i].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }


        //mirror image from middle col
        for (int i= 0; i< a.length; i++) {
            for (int j=0; j < ( a[i].length/2); j++) {
                int temp = a[i][j];
                a[i][j] = a[i][dim - j -1];
                a[i][dim - j-1] = temp;
            }
        }

    }




}

