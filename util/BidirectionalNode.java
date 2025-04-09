package util;

public class BidirectionalNode extends Node{

    public int value;
    public BidirectionalNode next;
    public BidirectionalNode pre;

    public BidirectionalNode(int num) {
        super(num);
        value = num;
        pre = null;
        next = null;
    }
}
