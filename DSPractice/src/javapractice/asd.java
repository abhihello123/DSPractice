package javapractice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {


    static int droppedRequests(List<Integer> requestTime) {
        Collections.sort(requestTime);
        int numDrops =0;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (Integer sec : requestTime) {
            if (map1.containsKey(sec)) {
                int value = map1.get(sec);
                map1.put(sec, ++value);
            } else {
                map1.put(sec, 1);
            }
        }

        int count10secs = 0;
        int count60secs = 0;
        int counter =0;
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (counter %10 == 0) {
                count10secs=0;
            }
            if (counter %60 == 0) {
                count60secs=0;
            }

            if (entry.getValue() >=4) {
                numDrops++;
            }
            count10secs += entry.getValue();
            if (count10secs > 20) {
                numDrops++;
            }
            count60secs += entry.getValue();
            if (count10secs > 60) {
                numDrops++;
            }

            counter++;
        }

        System.out.println(numDrops);


        return 0;
    }

    public static void main(String[] args) {
        List<Integer> requestTime = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7));
        droppedRequests(requestTime);
    }

}
