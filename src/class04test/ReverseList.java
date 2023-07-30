package class04test;


import java.util.Objects;

public class ReverseList {
    public static class Node {
        public int value;
        public ReverseList.Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        n1.next = new Node(20);
        n1.next.next = new Node(30);
        printNode(n1);
        n1 = reverseList(n1);
        System.out.println("反转链表后");
        printNode(n1);
    }

    /**
     * 逆序链表
     */
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 逆序链表
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        //前一个节点
        DoubleNode pre = null;
        //后一个节点
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.last = next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 输出单链表
     */
    public static void printNode(Node head) {
        while (Objects.nonNull(head)) {
            System.out.print(head.value + "\t");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 输出单链表
     */
    public static void printNode(DoubleNode head) {
        while (Objects.nonNull(head)) {
            System.out.print(head.value + "\t");
            head = head.next;
        }
        System.out.println();
    }
}
