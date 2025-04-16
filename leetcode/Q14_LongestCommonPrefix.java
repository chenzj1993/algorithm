package leetcode;
// leetcode: https://leetcode.com/problems/longest-common-prefix/description/

// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".

// Example 1:
// Input: strs = ["flower","flow","flight"]
// Output: "fl"

// Example 2:
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

public class Q14_LongestCommonPrefix {

    public String solution(String[] strs) {
        boolean flag = false;
        int minLength = Integer.MAX_VALUE;
        int i = 0;
        for (i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        for (i = 0; i < minLength; i++) {
            flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }

            }
            if (!flag) {
                break;
            }
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        var cls = new Q14_LongestCommonPrefix();
        String[] s = new String[] { "", "abc" };
        System.out.println(cls.solution(s));

    }

}