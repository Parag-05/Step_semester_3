package main.java.week9.class_problems;

public class MaximizeAreaBetweenTwoBoundaries {

    // Optimal Two-Pointer Approach: O(n) Time, O(1) Space
    public static int maxContainerArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(heights[left], heights[right]);
            int currentArea = width * minHeight;

            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer corresponding to the shorter wall
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights));
    }
}
