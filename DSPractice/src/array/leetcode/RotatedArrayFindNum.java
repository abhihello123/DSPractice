package array.leetcode;

/**
 * Can be two cases:
 * 1) mid is in the left sorted array
 * 2) mid is in the right sorted array
 * - Once we know for sure mid is in the sorted array apply normal binary search
 * - else keep on searching for the case where mid would be part of sorted subarray
 */
public class RotatedArrayFindNum {

    public static void main(String[] args) {
        RotatedArrayFindNum obj = new RotatedArrayFindNum();
        int[] arr = {5,1,2,3,4};
        int result = obj.search(arr, 3);
        System.out.println(result);
    }

    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int mid;
        while (left <= right) {
            mid = (left + right) /2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[left] <= arr[mid]) { //mid is in left sorted subarray
                if (target >= arr[left] && target < arr[mid]) {
                    //return binSearch(arr, left, mid-1, target); //element is in left sorted subarray
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else { //mid is in right sorted subarray
                if (target <= arr[right] && target >= arr[mid]) {
                    //return binSearch(arr, mid+1, right, target); //element is in right sorted subarray
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }

    private int binSearch(int[] arr, int left, int right, int target) {
        int middle;
        while (left<=right) {
            middle = (left+right) >>> 1;
            if (arr[middle] == target) return middle;
            if (target < arr[middle]) right = middle-1;
            else if (target > arr[middle]) left = middle+1;
        }
        return -1;
    }

}
