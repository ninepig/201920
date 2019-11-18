package company.oracle;

import LinkedList.ListNode;

import java.util.List;

public class reverseLinkedList206 {
    /*
     耻辱的一道题！
     o(n) time
     o(1) space
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /*
     o(n) time
     o(n) space
     */
    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    // facebook? record each node?
}
