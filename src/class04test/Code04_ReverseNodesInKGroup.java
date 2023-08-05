package class04test;

public class Code04_ReverseNodesInKGroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode end = getEndListNode(head, k);
        //判断第一个是否不需要反转
        if (end == null) {
            return head;
        }
        ListNode nextStart = end.next;
        ListNode start = head;
        reverse(start,end);
        head = end;
        ListNode lastEnd = start;
        while (end!=null){
            //获取新一轮的开始和结束
            start = nextStart;
            end = getEndListNode(start,k);
            if (end == null){
                return head;
            }
            //反转
            reverse(start,end);
            //将上一轮的最后一个节点指向这轮的
            lastEnd.next = end;
            //这一轮的最开始的节点变为上轮最后节点
            lastEnd = start;
            nextStart = start.next;
        }
        return head;
    }

    public ListNode getEndListNode(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public void reverse(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        end = end.next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }
}
