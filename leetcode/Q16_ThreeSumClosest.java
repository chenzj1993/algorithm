package leetcode;
// leetcode: https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
// Return the sum of the three integers.
// You may assume that each input would have exactly one solution.

// Example 1:
// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

// Example 2:
// Input: nums = [0,0,0], target = 1
// Output: 0
// Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

public class Q16_ThreeSumClosest {

    public int solution(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int tmp;
            while (left < right && closest != target) {
                tmp = nums[i] + nums[left] + nums[right];
                if (tmp > target) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(target - closest) > Math.abs(target - tmp)) {
                    closest = tmp;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        var cls = new Q16_ThreeSumClosest();
        int[] s = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int target = 1;
        System.out.println(cls.solution(s, target));

    }

}