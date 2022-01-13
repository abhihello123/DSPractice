package array.leetcode;

import java.util.*;

/**
 * Difficulty-Medium
 * Top 100 Interview Ques
 * Tag - Array
 *
 */
public class TripletsSum0InAnArray {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        //-4,-1,-1,0,1,2
        TripletsSum0InAnArray obj = new TripletsSum0InAnArray();
        List<List<Integer>> result = obj.threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] arr) {
        Set<String> resultSet = new HashSet<>();
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList();
        List<Integer> subResult;
        int target;
        int sum;
        String resultStr;
        for (int i=0; i<arr.length-2; i++) {
            target = 0 - arr[i];
            for (int j=i+1,k=arr.length-1;j<arr.length-1 && j!=k;) {
                sum = arr[j] + arr[k];
                if (sum == target) {
                    resultStr = String.format("%d%d%d",arr[i],arr[j],arr[k]);
                    if (!resultSet.contains(resultStr)) {
                        subResult = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k]));
                        result.add(subResult);
                        resultSet.add(resultStr);
                        break;
                    }
                }
                if (sum < target) j++;
                else k--;
            }
        }
        return result;
    }

}
