package leetcode;
// leetcode: https://leetcode.com/problems/zigzag-conversion/description/

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"

// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string s, int numRows);

// Example 1:
// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"

// Example 2:
// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
// P     I    N
// A   L S  I G
// Y A   H R
// P     I

// Example 3:
// Input: s = "A", numRows = 1
// Output: "A"

public class Q6_ZigzagConversion {

    public String solution(String s, int numRows) {
        if (s.length() < 2 || numRows == 1) {
            return s;
        }
        StringBuilder[] strs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            strs[i] = new StringBuilder();
        }
        int sign = -1;
        int curRow = 0;
        for (int i = 0; i < s.length(); i++) {
            strs[curRow] = strs[curRow].append(s.charAt(i));
            if (curRow == 0 || (curRow + 1) % numRows == 0) {
                sign = -sign;
            }
            curRow += sign;
        }
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            stringBuilder.append(strs[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        var cls = new Q6_ZigzagConversion();
        // int rows = 3;
        // String s = "PAYPALISHIRING";
        String s = "PAYPALISHIRING";
        int rows = 4;
        System.out.println(cls.solution(s, rows));
        // #b#a#b#a#d#

    }

}