package leetcode;
// leetcode: https://leetcode.com/problems/palindrome-number/

// Given an integer x, return true if x is a palindrome, and false otherwise.

// Example 1:
// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.

// Example 2:
// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

// Example 3:
// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

public class Q9_PalindromeNumber {

    public boolean solution(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int cmp = 0;
        while (tmp != 0) {
            cmp = cmp * 10 + tmp % 10;
            tmp /= 10;
        }
        return cmp == x ? true : false;
    }

    public static void main(String[] args) {
        var cls = new Q9_PalindromeNumber();
        int x = 10;
        System.out.println(cls.solution(x));

    }

}