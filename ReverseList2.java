/*
 * @Author: chenzj1993 chenzj1993@gmail.com
 * @Date: 2025-04-05 09:28:52
 * @LastEditors: chenzj1993 chenzj1993@gmail.com
 * @LastEditTime: 2025-04-05 10:35:49
 * @FilePath: \algorithm\reverseList.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFilecurer查看配置 进行设置: https://github.com/OBKoro1/koro1Filecurer/wiki/%E9%85%8D%E7%BD%AE
 */

import java.util.Random;

public class ReverseList2 {
    private Random random = new Random();

    @SuppressWarnings("unused")
    public static class Node {
        private int value;
        private Node next;
        private Node pre;

        public Node(int num) {
            value = num;
            next = null;
            pre = null;
        }
    }

    public static void printList(Node list) {
        Node cur = list;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();

    }

    public static Node reverse(Node list) {
        Node cur = list;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            cur.pre = next;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int num = 10;
        ReverseList2 process = new ReverseList2();
        Node head = new Node(process.random.nextInt(100));
        Node cur = head;
        for (var i = 1; i < num; i++) {
            Node node = new Node(process.random.nextInt(100));
            cur.next = node;
            cur = node;
        }
        printList(head);
        Node newHead = reverse(head);
        printList(newHead);

    }
}
