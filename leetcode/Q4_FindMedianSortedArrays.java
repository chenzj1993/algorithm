package leetcode;
// leetcode: https://leetcode.com/problems/median-of-two-sorted-arrays/

import java.util.ArrayList;

import util.GetRandomArray;
import util.GetTypeArrayFromArrayList;
import util.Print;

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).

// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

public class Q4_FindMedianSortedArrays {

    public double solution(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            var tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int length1 = nums1.length;
        int length2 = nums2.length;

        int low = 0;
        int high = length1;
        int left = (length1 + length2 + 1) / 2;

        while (low < high) {
            int i = (low + high + 1) / 2;
            int j = left - i;
            if (nums1[i - 1] > nums2[j]) {
                high = i - 1;
            } else {
                low = i;
            }
        }
        int i = low;
        int j = left - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == length1 ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == length2 ? Integer.MAX_VALUE : nums2[j];
        if ((length1 + length2) % 2 == 1) {
            return nums1LeftMax > nums2LeftMax ? nums1LeftMax : nums2LeftMax;
        } else {
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
        }
    }

    public static void main(String[] args) {

        String spliter = "=";

        int length1 = 20;
        int length2 = 110;
        ArrayList array1 = GetRandomArray.getRandomArrayList(length1, 50, 0);
        ArrayList array2 = GetRandomArray.getRandomArrayList(length2, 50, 0);
        array1.sort(null);
        array2.sort(null);
        Print.printArray(array1);
        Print.printArray(array2);
        int[] nums1 = GetTypeArrayFromArrayList.getArray(array1);
        int[] nums2 = GetTypeArrayFromArrayList.getArray(array2);
        Q4_FindMedianSortedArrays cls = new Q4_FindMedianSortedArrays();
        System.out.println(spliter.repeat(20));
        System.out.println("result:");
        System.out.println(cls.solution(nums1, nums2));
        // validation
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.addAll(array1);
        tmp.addAll(array2);
        tmp.sort(null);
        System.out.println(spliter.repeat(20));
        System.out.println("answer:");
        Print.printArray(tmp);
        if (tmp.size() % 2 == 0) {
            System.out.println((tmp.get(tmp.size() / 2) + tmp.get(tmp.size() / 2 - 1)) / 2.0);
        } else {
            System.out.println(tmp.get(tmp.size() / 2));
        }

    }

}