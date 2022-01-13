package array.leetcode;

/**
 * Output should be in O(logN)
 */
public class FirstLastElementInSortedArray {

    public static void main(String[] args) {
        FirstLastElementInSortedArray obj = new FirstLastElementInSortedArray();
        //int[] arr = {5,7,7,8,8,10};
        int[] arr = {2,2};
        int[] result = obj.searchRange(arr, 2);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] searchRange(int[] arr, int target) {
        int pos = binarySearch(arr, 0, arr.length -1, target);
        if (pos == -1) return new int[] {-1,-1};
        int left=pos;
        int right=pos;
        while (left > 0 && arr[left-1] == target) left--;
        while (right < (arr.length-1) && arr[right+1] == target) right++;
        return new int[] {left, right};
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        int mid;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (arr[mid] == target) return mid;
            if (target < arr[mid]) high = mid -1;
            else low = mid + 1;
        }
        return -1;
    }

}
