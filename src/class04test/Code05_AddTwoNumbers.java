package class04test;

/**
 * 全程自己解决
 */
// 测试链接：https://leetcode.com/problems/add-two-numbers/
public class Code05_AddTwoNumbers {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);
        ListNode maxLode = length1 > length2 ? l1 : l2;
        ListNode minLode = length1 > length2 ? l2 : l1;
        ListNode head = maxLode;
        ListNode cur = maxLode;
        //代表进位
        int x = 0;
        int gentle = 0;
        while (minLode != null) {
            gentle = maxLode.val + minLode.val + x;
            x = gentle / 10;
            maxLode.val = gentle % 10;
            cur = maxLode;
            maxLode = maxLode.next;
            minLode = minLode.next;
        }
        while (maxLode != null) {
            gentle = maxLode.val + x;
            x = gentle / 10;
            maxLode.val = gentle % 10;
            cur = maxLode;
            maxLode = maxLode.next;
        }
        if (x == 1) {
            ListNode end = new ListNode(1);
            cur.next = end;
        }
        return head;
    }

    public int getLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            listNode = listNode.next;
            length++;
        }
        return length;
    }
}
