package leetcode;
// leetcode: https://leetcode.com/problems/swap-nodes-in-pairs/

// Given a linked list, swap every two adjacent nodes and return its head.
// You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

// Example 1:
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]

// Example 2:
// Input: head = []
// Output: []

// Example 3:
// Input: head = [1]
// Output: [1]

// Example 4:
// Input: head = [1,2,3]
// Output: [2,1,3]

public class Q24_SwqpNodesInPairs {
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

    public ListNode solution(ListNode head) {
        ListNode cur = head;
        ListNode pre = new ListNode(0, head);
        head = pre;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Q24_SwqpNodesInPairs q22 = new Q24_SwqpNodesInPairs();
        System.out.println(q22.solution(null));
    }

}