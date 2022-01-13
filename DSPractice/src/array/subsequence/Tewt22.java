package array.subsequence;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Abhishek on 08-Mar-20.
 */
public class Tewt22 {

    public static void main(String[] args) {
        Map<String, Integer> lMap=new HashMap<String, Integer>();
        lMap.put("A", 35);
        lMap.put("B", 25);
        lMap.put("C", 50);

        MyComparator comp=new MyComparator(lMap);
        //System.out.println(lMap);

        Map<String,Integer> newMap = new TreeMap(comp);
        newMap.putAll(lMap);
        System.out.println(newMap);
    }

    static class MyComparator implements Comparator {

        Map map;

        public MyComparator(Map map) {
            this.map = map;
        }

        public int compare(Object o1, Object o2) {

            return ((Integer) map.get(o2)).compareTo((Integer) map.get(o1));

        }
    }
}
