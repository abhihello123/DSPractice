package array.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

public class StringEqual {

    public static void main(String[] args) {
/*        String s = "0";
        char[] main = s.toCharArray();
        if (main[0] == '1') System.out.println("true");
        else System.out.println("false");*/
        StringEqual obj = new StringEqual();
        //obj.
        /*System.out.println(obj.maximumRemovals("abcacb", "ab", new int[] {3,1,0}));
        System.out.println(obj.maximumRemovals("abcbddddd", "abcd", new int[] {3,2,1,4,5,6}));
         */
    }


    public int maximumRemovals(String s, String p, int[] removable) {
        //String str;
        int k=0;
        for (int i=0; i< removable.length; i++) {
            s = s.substring(0, removable[i]) + "0"
                    + s.substring(removable[i] + 1);
            //System.out.println(s);
            if (isSubsequence(s.toCharArray(), p.toCharArray())) {
                k++;
            }
        }
        return k;
    }

    private boolean isSubsequence(char[] main, char[] inner) {
        int prev = 0;
        for (int i=0; i< inner.length; i++) {
            boolean found = false;
            for (int j=prev; j < main.length && prev < main.length; j++) {
                if (main[j] == '0') continue;
                if (inner[i] == main[j]) {
                    //System.out.println(inner[i] + "--" + main[j]);
                    found = true;
                    prev = j+1;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }



    public boolean makeEqual(String[] words) {
        Map<Character, Integer> wordCountMap = new HashMap<>();
        for (String word: words) {
            char[] arr = word.toCharArray();
            for (Character c: arr) {
                if(wordCountMap.containsKey(c)) {
                    wordCountMap.put(c, wordCountMap.get(c) + 1);
                } else {
                    wordCountMap.put(c, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() % words.length != 0) {
                return false;
            }
        }
        return true;
    }

}
