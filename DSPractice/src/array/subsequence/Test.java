package array.subsequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        URL text = new URL("http://ocw.mit.edu/ans7870/6/6.006/s08/lecturenotes/files/t8.shakespeare.txt");
        URL stopWords = new URL("https://gist.githubusercontent.com/sebleier/554280/raw/7e0e4a1ce04c2bb7bd41089c9821dbcf6d0c786c/NLTK's%2520list%2520of%2520english%2520stopwords");
        URLConnection ucText = text.openConnection();
        URLConnection ucStopWords = stopWords.openConnection();
        BufferedReader inText = new BufferedReader(new InputStreamReader(
                ucText.getInputStream()));
        BufferedReader inStopWords = new BufferedReader(new InputStreamReader(
                ucStopWords.getInputStream()));
        String inputLineText;
        String inputLineStopWords;
        int counter = 1;
        Set<String> ignoreWords = new HashSet<>();
        Map<String, Integer> textMap = new HashMap<>();
        TreeMap<Integer, String>
                treemap = new TreeMap<>(
                Collections.reverseOrder());
        while ((inputLineStopWords = inStopWords.readLine()) != null) {
            ignoreWords.add(inputLineStopWords);
        }

        while ((inputLineText = inText.readLine()) != null) {
            if (counter++ > 244) {
                inputLineText.replaceAll(",","");
                inputLineText.replaceAll("[0-9]","");
                String[] lineArr = inputLineText.split(" ");
                for (String word : lineArr) {
                    if (!ignoreWords.contains(word)) {
                        if(textMap.containsKey(word)) {
                            textMap.put(word, textMap.get(word)+1);
                        } else {
                            textMap.put(word, 0);
                        }
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> entry : textMap.entrySet()) {
            treemap.put(entry.getValue(), entry.getKey());
        }
        counter = 1;
        for (Map.Entry<Integer, String> entry : treemap.entrySet()) {
            if (counter++ == 6)
                break;
            else
                System.out.println(String.format("%s - %s",entry.getValue(), entry.getKey()));
        }



        inText.close();
        inStopWords.close();
    }


















    public static void product(ArrayList<Integer> lis, int k) {
        int count = 0;
        for (int i = 0; i < lis.size(); i++) {
            for (int j = i; j < lis.size(); j++) {
                int product = 1;
                for (int l = i; l <= j && product <= k; l++) {
                    product = product * lis.get(l);
                }
                if (product <= k)
                    count = count + 1;
            }
        }
        System.out.println(count);
    }


    public static List<Integer> find_largest_three_from(List<Long> numbers) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        for (Long number : numbers) {
            if (number > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = number.intValue();
            } else if (number > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = number.intValue();
            } else if (number > thirdLargest) {
                thirdLargest = number.intValue();
            }
        }
        return new ArrayList(Arrays.asList(largest, secondLargest, thirdLargest));
    }

}
