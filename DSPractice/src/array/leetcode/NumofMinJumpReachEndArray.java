package array.leetcode;

public class NumofMinJumpReachEndArray {

    public static void main(String[] args) {
        NumofMinJumpReachEndArray obj = new NumofMinJumpReachEndArray();
        //int[] nums = {2,3,1,1,4};
        //int[] nums = {2,0};
        //int[] nums = {3,2,1,0,4};
        //int[] nums = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0,0};
        int[] nums = {2,0,3,3};
        System.out.println(obj.getMinJump(nums));
    }

    public int getMinJump(int[] arr) {
        int[] minJumpCount = new int[arr.length]; //minJUmpCount[0]=0; since its by default not setting it
        int jumpVal;
        for (int i=1; i< arr.length; i++) {
            for (int j=0; j<i; j++) {
                jumpVal = arr[j];
                if (i <= j + jumpVal) { //within reach
                    if (minJumpCount[i] == 0) {//empty
                        minJumpCount[i] = minJumpCount[j] + 1;
                    } else {
                        minJumpCount[i] = Math.min(minJumpCount[i], minJumpCount[j]+1);
                    }
                }
            }
        }
        return minJumpCount[arr.length -1];
    }
//to find path create another array JumpFrom with initialized as [-1] and when 0 comes again initialize as [-1] and trace the path
}
