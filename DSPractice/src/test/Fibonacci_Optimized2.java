package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abhishek on 26-Feb-20.
 */
//input   5
//output  0,1,1,2,3

public class Fibonacci_Optimized2 {

    Map<Integer, Integer> fiboMap = new HashMap<>();
    public static void main(String[] args) {
        Fibonacci_Optimized2 obj = new Fibonacci_Optimized2();
        int n=40;
        long start = System.currentTimeMillis();
        System.out.println(0);
        System.out.println(1);
        obj.fibo(n);
 /*       for (int i=1;i<=n;i++) {
            System.out.println(obj.fiboMap.get(i));
        }*/
        System.out.println((System.currentTimeMillis()-start)/1000.0);
    }

    /*
    fibo(n) - calculates nth fibonacci number
     */
    private int fibo(int num) {
        if (num == 1) {
            fiboMap.put(1,0);
            return 0;
        }
        if (num == 2) {
            fiboMap.put(2,1);
            return 1;
        }

        Integer right = fiboMap.get(num-2);
        if (right == null)
            right = fibo(num -2);

        Integer left = fiboMap.get(num-1);
        if (left == null)
            left = fibo(num -1);

        int number = left + right;
        System.out.println(number);
        fiboMap.put(num, number);
        return number;
    }
}
