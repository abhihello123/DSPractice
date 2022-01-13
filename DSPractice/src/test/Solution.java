package test;

import java.util.Base64;

class Solution {

    public static void main(String[] args) {
/*        System.out.println();
        Solution solution = new Solution();
        int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0,-1,-2};
        System.out.println(solution.solution(A));*/
        // create a sample String to encode
        String sample = "India Team will win the Cup";

        // print actual String
        System.out.println("Sample String:\n"
                + sample);
        String BasicBase64format
                = Base64.getEncoder()
                .encodeToString(sample.getBytes());

    }

    int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] diffArr = new int[A.length -1];
        for (int i=1; i< A.length; i++) {
            diffArr[i-1] = A[i] - A[i-1];
        }
        int globalCount = 0;
        int count=1;
        for (int i=1; i< diffArr.length; i++) {
            if (diffArr[i] == diffArr[i-1]) {
                count++;
            }
            else {
                if (count >=2) {
                    globalCount += factorial(count) / (factorial(count - 2) * 2);
                }
                count = 1;
            }
        }
        if (count >=2) {
            globalCount += factorial(count) / (factorial(count - 2) * 2);
        }
        return globalCount;
    }

    int factorial(int n) {
        int fact = 1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }

}