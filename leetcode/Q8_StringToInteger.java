package leetcode;
// leetcode: https://leetcode.com/problems/string-to-integer-atoi/description/ 

// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

// The algorithm for myAtoi(string s) is as follows:

// Whitespace: Ignore any leading whitespace (" ").
// Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
// Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
// Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
// Return the integer as the final result.

// Example 1:
// Input: s = "42"
// Output: 42
// Explanation:
// The underlined characters are what is read in and the caret is the current reader position.
// Step 1: "42" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "42" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "42" ("42" is read in)
//            ^

// Example 2:
// Input: s = " -042"
// Output: -42
// Explanation:
// Step 1: "   -042" (leading whitespace is read and ignored)
//             ^
// Step 2: "   -042" ('-' is read, so the result should be negative)
//              ^
// Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
//                ^

// Example 3:
// Input: s = "1337c0d3"
// Output: 1337
// Explanation:
// Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
//              ^

// Example 4:
// Input: s = "0-1"
// Output: 0
// Explanation:
// Step 1: "0-1" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
//           ^

// Example 5:
// Input: s = "words and 987"
// Output: 0
// Explanation:
// Reading stops at the first non-digit character 'w'.

public class Q8_StringToInteger {

    public int solution(String s) {
        int cur = 0;
        int result = 0;
        while (cur < s.length()) {
            if (s.charAt(cur) != ' ') {
                break;
            }
            cur++;
        }
        int sign = 1;
        if (cur < s.length() && (s.charAt(cur) == '-' || s.charAt(cur) == '+')) {
            sign = s.charAt(cur) == '-' ? -1 : 1;
            cur++;
        }
        while (cur < s.length() && s.charAt(cur) <= '9' && s.charAt(cur) >= '0') {
            if (result >= Integer.MAX_VALUE / 10) {
                if (sign == -1) {
                    if (result > Integer.MAX_VALUE / 10 || s.charAt(cur) >= '8') {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (result > Integer.MAX_VALUE / 10 || s.charAt(cur) >= '7') {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            result = result * 10 + s.charAt(cur++) - '0';
        }
        return sign == 1 ? result : -result;
    }

    public static void main(String[] args) {
        var cls = new Q8_StringToInteger();
        System.out.println(Integer.MIN_VALUE);
        String x = "-91283472332";
        System.out.println(cls.solution(x));

    }

}