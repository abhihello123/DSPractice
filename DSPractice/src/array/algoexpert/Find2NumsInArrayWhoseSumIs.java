package array.algoexpert;

import java.util.*;
import java.util.stream.Collectors;

public class Find2NumsInArrayWhoseSumIs {

    public static void main(String[] args) {
        int[] arr = {3,5,-4,8,11,1,-1,6};
        int[] output = find2NumsWhoseSumIsInput(arr, 10);
        System.out.println(Arrays.toString(output));
        int[] output2 = find2NumsWhoseSumIsInput(arr, 100);
        System.out.println(Arrays.toString(output2));
        int[] output3 = find2NumsWhoseSumIsInputStreams(arr, 10);
        System.out.println(Arrays.toString(output3));
        int[] output4 = find2NumsWhoseSumIsInputStreams(arr, 100);
        System.out.println(Arrays.toString(output4));
    }

    private static int[] find2NumsWhoseSumIsInput(int[] arr, int sum) {
        List<Integer> outList = new ArrayList<>(); //o(2) space max
        Set<Integer> arrSet = Arrays.stream(arr).boxed().collect(Collectors.toSet()); //o(n) time, o(n) space
        for (int num : arr) { //o(n) max
            if(arrSet.contains(sum - num) && !(num == (sum - num))) { //o(1) //distinct integers so not a prob
                outList.add(num);
                outList.add(sum-num);
                break;
            }
        }
        return outList.stream().mapToInt(i->i).toArray();
    }

    private static int[] find2NumsWhoseSumIsInputStreams(int[] arr, int sum) {
        Set<Integer> arrSet = Arrays.stream(arr).boxed().collect(Collectors.toSet()); //o(n) time, o(n) space
        Optional<Integer> oneNumber = arrSet.stream().filter(num -> (arrSet.contains(sum - num)  && !(num == (sum - num))))
                .findFirst(); //o(n) max
        if (oneNumber.isPresent()) {
            return new int[]{oneNumber.get(), (sum - oneNumber.get())};
        } else {
            return new int[0];
        }
    }

}
