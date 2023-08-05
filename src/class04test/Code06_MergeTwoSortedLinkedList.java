package class04test;

public class Code06_MergeTwoSortedLinkedList {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //判断是否存在链表为空
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        //选取值较小的为起始节点,相同选list1
        ListNode head = list1.val > list2.val ? list2 : list1;
        ListNode cur2 = head == list1 ? list2 : list1;
        ListNode cur1 = head.next;
        ListNode cur = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            } else {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }
        }
        if (cur1 != null) {
            cur.next = cur1;
        } else if (cur2 != null) {
            cur.next = cur2;
        }
        return head;
    }
}
