package array.algoexpert;

public class FirstDuplicateValue {

    public static void main(String[] args) {
        int arr[] = {2,1,5,3,6,3,2,4};
        System.out.println(usingBitWiseOr(arr));
    }

    private static int usingBitWiseOr(int[] arr) {
        int prev = -1;
        int curr = arr[0];
        int next = curr;
        int foundValue = -1;

        for (int i=1; i<arr.length -1; i++) {
            curr = next;
            next = next ^ arr[i];
            if (next == prev) {
                foundValue = arr[i];
                break;
            }
            prev = curr;
            //curr = curr ^ arr[i];
        }
        return foundValue;
    }

}
