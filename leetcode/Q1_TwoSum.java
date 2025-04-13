package leetcode;
// leetcode: https://leetcode.com/problems/two-sum/description/

import java.util.HashMap;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

public class Q1_TwoSum {

    public int[] solution(int[] nums, int target) {
        int[] result = new int[2];
        int tmp;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            tmp = target - nums[i];
            if (map.get(tmp) != null) {
                result[0] = map.get(tmp);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        Q1_TwoSum process = new Q1_TwoSum();
        int[] result1 = process.solution(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println("nums: [2,7,11,15]");
        System.out.println("target: 9");
        System.out.printf("result: [%d,%d]",result1[0],result1[1]);
        System.out.println();
    }

}
