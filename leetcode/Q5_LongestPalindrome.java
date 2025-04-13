package leetcode;
// leetcode: https://leetcode.com/problems/longest-palindromic-substring/

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

public class Q5_LongestPalindrome {

    public String solution(String s) {
        if (s.length() < 2) {
            return s;
        }
        s = s.replaceAll("", "#");
        int[] help = new int[s.length()];
        int r = 0;
        int center = 0;
        int cur = 0;
        int maxLength = -1;
        String result = "";
        while (cur < s.length()) {
            if (cur < r) {
                help[cur] = Math.min(r - cur, help[2 * center - cur]);
            }
            while (cur - help[cur] - 1 >= 0 && cur + help[cur] + 1 < help.length
                    && s.charAt(cur - help[cur] - 1) == s.charAt(cur + help[cur] + 1)) {
                help[cur]++;
            }
            if (cur + help[cur] > r) {
                center = cur;
                r = cur + help[cur];
            }
            if (help[cur] > maxLength) {
                result = s.substring(cur - help[cur], cur + help[cur] + 1);
                maxLength = help[cur];
            }
            cur++;
        }
        return result.replaceAll("#", "");
    }

    public static void main(String[] args) {
        // String s =
        // "aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa";
        String s = "aaabaaaa";

        var cls = new Q5_LongestPalindrome();
        System.out.println(cls.solution(s));
        // #b#a#b#a#d#

    }

}