import java.util.ArrayList;

import util.GetRandomArray;
import util.Node;
import util.Print;

public class MergeTwoOrderList {

    private Node getOrderList(ArrayList<Integer> arrayList) {
        arrayList.sort(null);
        Node head = new Node(0);
        Node cur = head;
        for (int i = 0; i < arrayList.size(); i++) {
            cur.next = new Node(arrayList.get(i).intValue());
            cur = cur.next;
        }
        head = head.next;
        return head;

    }

    private Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node head;
        Node cur;
        Node cur1;
        Node cur2;
        if (head1.value <= head2.value) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }
        cur = head;
        cur1 = head1;
        cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;

        }
        cur.next = cur1 == null ? cur2 : cur1;

        return head;
    }

    public static void main(String[] args) {
        MergeTwoOrderList mergeTwoOrderList = new MergeTwoOrderList();
        int length1 = 20;
        int length2 = 25;
        ArrayList array1 = GetRandomArray.getRandomArrayList(length1, 50, 0);
        ArrayList array2 = GetRandomArray.getRandomArrayList(length2, 50, 0);
        array1.sort(null);
        array2.sort(null);
        Print.printArray(array1);
        Print.printArray(array2);
        Node list1 = mergeTwoOrderList.getOrderList(array1);
        Node list2 = mergeTwoOrderList.getOrderList(array2);
        Node mergedList = mergeTwoOrderList.merge(list1, list2);
        Print.printList(mergedList);

    }

}
