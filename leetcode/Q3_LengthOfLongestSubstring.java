package leetcode;
// leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashMap;

// Given a string s, find the length of the longest substring without duplicate characters.

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

public class Q3_LengthOfLongestSubstring {

    public int solution(String s) {
        char[] charArray = s.toCharArray();
        int left = -1;
        int maxLength = 0;
        int currentLength = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) == null) {
                map.put(charArray[i], i);
                currentLength++;
            } else {
                if (map.get(charArray[i]) < left) {
                    currentLength++;
                } else {
                    maxLength = currentLength > maxLength ? currentLength : maxLength;
                    currentLength = i - map.get(charArray[i]);
                    left = map.get(charArray[i]) + 1;
                }
                map.put(charArray[i], i);
            }
        }
        maxLength = currentLength > maxLength ? currentLength : maxLength;
        return maxLength;
    }

    public static void main(String[] args) {
        Q3_LengthOfLongestSubstring question = new Q3_LengthOfLongestSubstring();
        int result = question.solution("abcabcbb");
        System.out.println(result);
    }
}
