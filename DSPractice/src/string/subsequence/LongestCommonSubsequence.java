package string.subsequence;

import array.subsequence.LongestIncreasingSubsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by Abhishek on 16-Aug-19.
 */
//NOT COMPLETE. DIFFICULT QUESTION
public class LongestCommonSubsequence {

    public static void main(String[] args) throws IOException {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        System.out.println(num);
        num=num*3;
        int size1 = 0;
        int size2 = 0;
        String s1 = null;
        String s2 = null;
        for (int i=0; i<num; i++) {
            if (i%3==0) {
                String array[] = reader.readLine().split(" ");
                size1 = Integer.parseInt(array[0]);
                size2 = Integer.parseInt(array[1]);
            } else if (i%3==1) {
                s1 = reader.readLine();
            } else {
                s2 = reader.readLine();
                longestCommonSeq(s1, s2, size1, size2);
            }
        }
    }

    private static void longestCommonSeq(String str1, String str2, int size1, int size2) {
        System.out.println(String.format("%s,%s,%d,%d",str1, str2, size1, size2));
        
    }

}
