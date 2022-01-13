package array.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 46
 * for n elements in an array output would be n*(n-1)*(n-2)*....(n-(n-1))
 * for 4 elements it would be 4*3*2 = 24 elements
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class ArrayPermutations {

    public static void main(String[] args) {
        ArrayPermutations obj = new ArrayPermutations();
        int[] nums = {1,2,3};
        List<List<Integer>> result = obj.permute(nums);
        System.out.println(result);
        System.out.println(result.size());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(result, nums, 0);
        return result;
    }

    //Backtracking
    private void permutations(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> tempList = new ArrayList<>(nums.length);
            for (int i: nums) tempList.add(i);
            result.add(tempList);
        }
        for (int i=start; i < nums.length; i++) {
            swap(nums, start, i);
            permutations(result, nums, start+1);
            swap(nums, i, start); //make swapped array original again
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
