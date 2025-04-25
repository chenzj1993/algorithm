package leetcode;
// leetcode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

// Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Example 2:
// Input: head = [1], n = 1
// Output: []

// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]

public class Q19_RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode solution(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode tmp = head;
        for (int i = 0; i < n; i++) {
            tmp = tmp.next;
        }
        while (tmp != null) {
            node = node.next;
            tmp = tmp.next;
        }
        if (node.next == head) {
            return head.next;
        }else{
            node.next = node.next.next;
        }

        return head;

    }

    public static void main(String[] args) {
    }

}