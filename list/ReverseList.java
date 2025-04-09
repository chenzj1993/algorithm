
import java.util.Random;

import util.Node;
import util.Print;

public class ReverseList {
    private Random random = new Random();

    public static Node reverse(Node list) {
        Node cur = list;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int num = 10;
        ReverseList process = new ReverseList();
        Node head = new Node(process.random.nextInt(100));
        Node cur = head;
        for (var i = 1; i < num; i++) {
            Node node = new Node(process.random.nextInt(100));
            cur.next = node;
            cur = node;
        }
        Print.printList(head);
        Node newHead = reverse(head);
        Print.printList(newHead);

    }
}
