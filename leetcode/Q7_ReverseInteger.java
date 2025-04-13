package leetcode;
// leetcode: https://leetcode.com/problems/reverse-integer/description/

// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

// Example 1:
// Input: x = 123
// Output: 321

// Example 2:
// Input: x = -123
// Output: -321

// Example 3:
// Input: x = 120
// Output: 21

public class Q7_ReverseInteger {

    public int solution(int x) {
        int result = 0;
        while (x != 0) {

            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }

            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;

    }

    public static void main(String[] args) {
        var cls = new Q7_ReverseInteger();
        int x = -901000;
        System.out.println(cls.solution(x));

    }

}