package leetcode;
// leetcode: https://leetcode.com/problems/regular-expression-matching/

// Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
// '.' Matches any single character.​​​​
// '*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial).

// Example 1:
// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".

// Example 2:
// Input: s = "aa", p = "a*"
// Output: true
// Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

// Example 3:
// Input: s = "ab", p = ".*"
// Output: true
// Explanation: ".*" means "zero or more (*) of any character (.)".

public class Q10_RegularExpressionMatch {

    public boolean solution(String s, String p) {
        if (s.length() == 0 || p.length() == 0) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        dp[0][1] = false;
        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            } else {
                dp[0][j] = false;
            }
        }
        for (int m = 0; m < s.length(); m++) {
            for (int n = 0; n < p.length(); n++) {
                if (s.charAt(m) == p.charAt(n) || '.' == p.charAt(n)) {
                    dp[m + 1][n + 1] = dp[m][n];
                } else {
                    if (p.charAt(n) == '*') {
                        if (dp[m + 1][n - 1] == true || ((s.charAt(m) == p.charAt(n - 1) || p.charAt(n - 1) == '.')
                                && dp[m][n + 1] == true)) {
                            dp[m + 1][n + 1] = true;
                        }
                    }
                }

            }
        }
        return dp[s.length()][p.length()];

    }

    public static void main(String[] args) {
        var cls = new Q10_RegularExpressionMatch();
        String s = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
        String p = ".*";
        System.out.println(cls.solution(s, p));

    }

}