package leetcode;
// leetcode: https://leetcode.com/problems/merge-two-sorted-lists

import java.util.ArrayList;
import java.util.List;

// You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.

// Example 1:
// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]

// Example 2:
// Input: list1 = [], list2 = []
// Output: []

// Example 3:
// Input: list1 = [], list2 = [0]
// Output: [0]`

public class Q22_GenerateParenthesis {

    private void process(List<String> result, String s, int parenthesis, int leftCount, int rightCount) {
        if (leftCount == parenthesis && rightCount == parenthesis) {
            result.add(s);
        }
        if (leftCount < parenthesis) {
            process(result, s + "(", parenthesis, leftCount + 1, rightCount);
        }
        if (rightCount < leftCount) {
            process(result, s + ")", parenthesis, leftCount, rightCount + 1);
        }

    }

    public List<String> solution(int n) {
        List<String> result = new ArrayList<String>();
        process(result, "", n, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        Q22_GenerateParenthesis q22 = new Q22_GenerateParenthesis();
        System.out.println(q22.solution(3));
    }

}