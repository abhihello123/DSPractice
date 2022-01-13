/*
package ll;

import java.util.*;
import java.util.LinkedList;

public class Test2 {

    int size = 1024;

    LinkedList[] arr = new LinkedList[size];

    public static void main(String[] args) {
        Map<String, String> amap = new HashMap<>();
        amap.put("abc","xyz");
        amap.put("abc","pqr");
        System.out.println(amap);
        Collections.sort(new HashSet<String>());
    }

    private <K,V>boolean put(K key, V value) {
        int hashcode = key.hashCode();
        int index = hashcode % size;
        Pair<K, V> pair = new Pair<>();
        pair.setKey(key);
        pair.setValue(value);
        if (arr[index] == null) {
            LinkedList ll = new LinkedList();
            ll.add(pair);
            arr[index] = ll;
            return true;
        } else {
            LinkedList ll = arr[index];
            Iterator itr = ll.descendingIterator();
            while (itr.hasNext()) {
                Pair<K,V> pair2 = (Pair<K, V>) itr.next();
                if (pair2.getKey().equals(key)) {
                    value = pair2.getValue();

                    return false;
                }
            }
            ll.add(pair);
            return true;
        }
    }

    private <K,V> V get(K key) {
        int hashcode = key.hashCode();
        int index = hashcode % size;
        V value = null;
        if (arr[index] == null) {
            return null; // element not present in Map
        } else {
            LinkedList ll = arr[index];
            Iterator itr = ll.descendingIterator();
            while (itr.hasNext()) {
                Pair<K,V> pair = (Pair<K, V>) itr.next();
                if (pair.getKey().equals(key)) {
                    value = pair.getValue();
                }
            }
        }
        return value;
    }


}
*/
