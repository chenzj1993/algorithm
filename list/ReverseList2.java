
import java.util.Random;
import util.BidirectionalNode;
import util.Print;

public class ReverseList2 {
    private Random random = new Random();

    public static BidirectionalNode reverse(BidirectionalNode list) {
        BidirectionalNode cur = list;
        BidirectionalNode pre = null;
        BidirectionalNode next = null;
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
        BidirectionalNode head = new BidirectionalNode(process.random.nextInt(100));
        BidirectionalNode cur = head;
        for (var i = 1; i < num; i++) {
            BidirectionalNode node = new BidirectionalNode(process.random.nextInt(100));
            cur.next = node;
            cur = node;
        }
        Print.printList(head);
        BidirectionalNode newHead = reverse(head);
        Print.printList(newHead);

    }
}
