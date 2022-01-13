package array.leetcode.contest;

import java.util.Arrays;

class RangeQues {
/*    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[51];
        boolean covered = true;
        *//*for (int i=left; i<=right; i++) {
            for (int j=0; j<)
        }*//*
        System.out.println(arr.length);
        for (int i=0; i< ranges.length; i++) {
            int min = ranges[i][0];
            int max = ranges[i][1];
            System.out.println(min + "--" + max);
            for (int j=min; j<=max;j++) {
                arr[j] = 1;
            }
        }

        for (int i=left;i<=right;i++)
        if (arr[i] == 0) {
            covered = false;
            break;
        }
        return covered;
    }*/

    public static int chalkReplacer(int[] chalk, int k) {
        long totalChalkOneSet=0;
        for (int i:chalk) totalChalkOneSet +=i;
        System.out.println(totalChalkOneSet);
        long remainder = k%totalChalkOneSet;
        int ans=0;
        for (int i=0;i<chalk.length;i++) {
            if (chalk[i] > remainder) {
                ans = i;
                break;
            } else {
                remainder-=chalk[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int matrix[] = {5,1,5};
        System.out.println(chalkReplacer(matrix, 22));

        //System.out.println(isCovered(matrix, 21, 21));
    }




}