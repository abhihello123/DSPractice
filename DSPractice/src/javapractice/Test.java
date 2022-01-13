package javapractice;

import java.util.*;

/**
 * Created by Abhishek on 28-Sep-19.
 */
public class Test {

    static int tasks(int n, List<Integer> a, List<Integer> b) {

        int numOfInterDepTasks=0;
        Map<Integer, Integer> map1 = new HashMap<>();

        Iterator itr = a.iterator();
        Iterator itr2 = b.iterator();

        while (itr.hasNext()) {
            map1.put((Integer)itr.next(), (Integer)itr2.next());
        }

        int key, value,value2;
        int depTasks=0;

        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            if (map1.containsKey(value)) {
                value2 = map1.get(value);
                if (key == value2) {
                    depTasks++;
                }
            }
        }
        depTasks/=2;
        System.out.println((n-depTasks));


        return 0;
    }

    public static void main(String[] args) {
/*        List<Integer> list1 = new ArrayList<>(Arrays.asList());
        //List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,6,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList());
        //List<Integer> list2 = new ArrayList<>(Arrays.asList(7,6,4,1,2,1));
        tasks(2, list1, list2);*/
        String message = "alaasass";
        compressedString(message);
    }//a1l1a2s1a1s2

    public static String compressedString(String message) {
        // Write your code here
        char[] charArr = message.toCharArray();
        int numOccurance=1;
        char prevCh=0;
        boolean isFirst=true;
        StringBuilder sb = new StringBuilder();
        for (char ch : charArr) {
            if (isFirst) {
                prevCh = ch;
                isFirst = false;
                continue;
            }
            if (ch==prevCh) {
                numOccurance++;
            } else {
                sb.append(prevCh);
                if (numOccurance > 1)
                    sb.append(numOccurance);
                prevCh = ch;
                numOccurance = 1;
            }
        }
        sb.append(prevCh);
        if (numOccurance > 1)
            sb.append(numOccurance);
        System.out.println(sb);
        return null;
    }



}
