package array.subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by Abhishek on 15-Aug-19.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) throws IOException {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        num=num*2;
        int size=0;
        int[] arr;
        for (int i=0; i<num; i++) {
            if (i%2==0) {
                size = Integer.parseInt(reader.readLine());
                arr = new int[size];
            } else {
                String array[] = reader.readLine().split(" ");
                arr = Stream.of(array).mapToInt(ele -> Integer.parseInt(ele)).toArray();
                obj.printLongestIncSubsequence(arr, size);
            }
        }
    }

    private void printLongestIncSubsequence(int[] arr, int size) {
        long start = System.currentTimeMillis();
        int[] lisAr = new int[size];
        int maxChainLenFound=0;
        int tempLis;
        for (int i=1; i<size; i++) {
            for (int j=0; j<i; j++) {
                if(arr[j] < arr[i]) {
                    tempLis = lisAr[j] + 1;
                    if (tempLis > lisAr[i]) {
                        lisAr[i] = tempLis;
                    }
                }
                if (lisAr[i] > maxChainLenFound)
                    maxChainLenFound = lisAr[i];
            }
        }
        System.out.println(maxChainLenFound+1);
        System.out.println("Took " + (System.currentTimeMillis() - start) + " ms");

    }

}
