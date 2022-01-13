package array.leetcode;

/**
 * Leetcode 55
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class PossibleMaxJumpPossibleReachEnd {

    public static void main(String[] args) {
        PossibleMaxJumpPossibleReachEnd obj = new PossibleMaxJumpPossibleReachEnd();
        //int[] nums = {2,3,1,1,4};
        //int[] nums = {2,0};
        //int[] nums = {3,2,1,0,4};
        //int[] nums = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0,0};
        int[] nums = {2,0,3,3};
        System.out.println(obj.canJumpCheckMax(nums));
    }


    // check max reachability at each point, if max reachability is less than current posn return false
    // best solution but only can check if can be reached cannot be used to find num of steps or path
    public boolean canJumpCheckMax(int[] arr) {
        if (arr.length == 0) return false;
        int max_reach = 0;
        int curr_reach;
        for (int i=0; i<arr.length && i<=max_reach;i++) {
            if (max_reach >= arr.length -1) return true;
            if (arr[i] != 0) {
                curr_reach = i + arr[i];
                if (curr_reach > max_reach)
                    max_reach = curr_reach;
            }
        }
        return false;
    }







    // Back Tracking Not Efficient for Large values, not efficient solution for this case.

    public boolean canJumpBackTrack(int[] nums) {
        if (nums.length == 0) return false;
        return backTrackJump(nums, 0);
    }

    private boolean backTrackJump(int[] nums, int start) {
        if (start == nums.length -1) return true;
        if (nums[start] == 0) return false;
        int maxStep = Math.min((start + nums[start]), (nums.length - 1));
        for (int i =  maxStep; i > start; i--) {
            if (backTrackJump(nums, i)) return true;
        }
        return false;
    }

}
