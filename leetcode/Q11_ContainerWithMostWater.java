package leetcode;
// leetcode: https://leetcode.com/problems/container-with-most-water/description/

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

// Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

// Example 2:
// Input: height = [1,1]
// Output: 1

public class Q11_ContainerWithMostWater {

    public int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        int tmp = max;
        while (left < right) {
            tmp = (right - left) * Math.min(height[right], height[left]);
            if (tmp > max) {
                max = tmp;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        var cls = new Q11_ContainerWithMostWater();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(cls.solution(height));

    }

}