package leetcode;
// leetcode: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:
// Input: digits = ""
// Output: []

// Example 3:
// Input: digits = "2"
// Output: ["a","b","c"]

public class Q17_LetterCombinationsOfPhoneNumber {

    public List<String> solution(String digits) {
        String[] numbers = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> list = new ArrayList<String>();
        if (digits.length() == 0) {
            return list;
        }
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (list.get(0).length() != i + 1) {
                int numIndex = digits.charAt(i) - '0' - 2;
                String tmp = list.remove(0);
                for (int k = 0; k < numbers[numIndex].length(); k++) {
                    list.add(tmp + numbers[numIndex].charAt(k));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        var cls = new Q17_LetterCombinationsOfPhoneNumber();
        String s = "234";
        System.out.println(cls.solution(s));

    }

}