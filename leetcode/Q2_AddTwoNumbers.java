package leetcode;
// leetcode: https://leetcode.com/problems/add-two-numbers/description/

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example 1:
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.

// Example 2:
// Input: l1 = [0], l2 = [0]
// Output: [0]

// Example 3:
// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]

public class Q2_AddTwoNumbers {

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

    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = null;
        int carry = 0;
        int sum = 0;
        int digit = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            digit = sum % 10;

            if (head == null) {
                head = new ListNode(digit);
                cur = head;
            } else {
                cur.next = new ListNode(digit);
                cur = cur.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode tmp = l1 == null ? l2 : l1;
        while (tmp != null) {
            sum = tmp.val + carry;
            carry = sum / 10;
            digit = sum % 10;
            if (head == null) {
                head = new ListNode(digit);
                cur = head;
            } else {
                cur.next = new ListNode(digit);
                cur = cur.next;
            }
            tmp = tmp.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return head;
    }

    ListNode getList(int[] nums) {
        Q2_AddTwoNumbers process = new Q2_AddTwoNumbers();
        ListNode head = null;
        ListNode cur = null;

        for (int i = 0; i < nums.length; i++) {
            if (head == null) {
                head = process.new ListNode(nums[i]);
                cur = head;
            } else {
                cur.next = process.new ListNode(nums[i]);
                cur = cur.next;

            }
        }
        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode result = null;
        Q2_AddTwoNumbers process = new Q2_AddTwoNumbers();

        int[] nums1 = { 9, 9, 9, 9, 9, 9, 9 };
        int[] nums2 = { 9, 9, 9, 9 };
        l1 = process.getList(nums1);
        l2 = process.getList(nums2);
        System.out.println("l1: ");
        process.printList(l1);
        System.out.println("l2: ");
        process.printList(l2);
        result = process.solution(l1, l2);
        System.out.println("result: ");
        process.printList(result);
    }

}
