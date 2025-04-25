package leetcode;
// leetcode: https://leetcode.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

// Example 1:
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

// Example 2:
// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]

public class Q18_FourSum {

    public List<List<Integer>> solution(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 3; i++) {

            while (i < nums.length - 3 && i != 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            long threeTarget = (long)target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                while (j < nums.length - 2 && j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                }
                while (j < nums.length - 2 && threeTarget < 0 && nums[j] > 0
                        && Integer.MIN_VALUE - threeTarget > -nums[j]) {
                    break;
                }
                while (j < nums.length - 2 && threeTarget > 0 && nums[j] < 0
                        && Integer.MAX_VALUE - threeTarget < -nums[j]) {
                    j++;
                }
                if (j == nums.length - 2) {
                    break;
                }
                long twoTarget = threeTarget - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                long tmp;
                while (left < right) {
                    tmp = nums[left] + nums[right];
                    if (tmp > twoTarget) {
                        right--;
                    } else if (tmp < twoTarget) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right]));
                        while (left < right && left != j + 1 && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var cls = new Q18_FourSum();
        // int[] s = new int[] { 1, 0, -1, 0, -2, 2 };
        // int target = 0;
        int[] s = new int[] { 1000000000, 1000000000, 1000000000, 1000000000 };
        int target = -294967296;
        
        System.out.println(cls.solution(s, target));

    }

}