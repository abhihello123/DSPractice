package string.subsequence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Abhishek on 26-Feb-20.
 */
public class SwapFirstLastCharEveryWord {

/*    Input : geeks for geeks
    Output :seekg rof seekg*/

    public static void main(String[] args) {
        SwapFirstLastCharEveryWord obj = new SwapFirstLastCharEveryWord();
        String str = "geeks for geeks";
        System.out.println(str);
        System.out.println(obj.swapFirstLastCharEveryWord1(str));
    }

    private String swapFirstLastCharEveryWord2(String str) {
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" ");
        int j=0;
        for (String word : arr) {
            char[] wordarr = word.toCharArray();
            char temp = wordarr[0];
            wordarr[0] = wordarr[wordarr.length - 1];
            wordarr[wordarr.length - 1] = temp;
            String newStr = new String(wordarr);
            sb.append(newStr).append(" ");
        }
        sb.delete(sb.length()-1, sb.length()-1);
        return sb.toString();
    }

    private String swapFirstLastCharEveryWord1(String str) {
        char[] arr = str.toCharArray();
        for (int i=0; i< arr.length; i++) {
            int k=i;
            while (i <= arr.length-1 && arr[i]!=' ') {
                i++;
            }
            char temp = arr[k];
            arr[k] = arr[i-1];
            arr[i-1] = temp;
            System.out.println(new String(arr));
        }
        return new String(arr);
    }

/*    private void abc() {
        CompletableFuture c = new CompletableFuture();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(null);

        CompletableFuture.supplyAsync(() -> getStockInfo("GOOGL"))   // executed in a thread-pool
                .thenApplyAsync(Stock::getRate)   // callback method once above lambda (getStockInfo) is completed
                .thenAccept(rate -> System.out.println(rate))
                .thenRun(() -> System.out.println("done"));

    }*/



}
