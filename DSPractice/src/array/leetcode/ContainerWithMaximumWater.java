package array.leetcode;

/**
 * Difficulty-Medium
 * Top 100 Interview Ques
 * Tag - Array
 *
 * Runtime: 2 ms, faster than 97.82% of Java online submissions for Container With Most Water.
 * Memory Usage: 52.4 MB, less than 76.01% of Java online submissions for Container With Most Water.
 */
public class ContainerWithMaximumWater {

    public static void main(String[] args) {
        ContainerWithMaximumWater obj = new ContainerWithMaximumWater();
        //int[] height = {1,8,6,2,5,4,8,3,7};
        //int[] height = {1,1};
        //int[] height = {4,3,2,1,4};
        int[] height = {1,2,1};
        int maxArea = obj.maxArea(height);
        System.out.println("Max Area :: " + maxArea);
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int area;
        for (int i =0, j = height.length-1; i!=j;) {
            area = Math.min(height[i],height[j]) * (j-i);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i]< height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }

}
