package company.oracle.mianjing.list;

import LinkedList.ListNode;

/*
1 quick method, just swap the value of two node.
2 if they both exists? if not exists, what should we do?

 */
public class swapTwoLinkedList {
    public ListNode swapTwoLinkedList(ListNode l1 , ListNode l2 , ListNode head){
        if (head == null || l1 == null || l2 == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // Locate l1
        ListNode preL1 = null;
        ListNode cur = head;
        while (cur != null && cur != l1){
            preL1 = cur;
            cur = cur.next;
        }

        ListNode preL2 = null;
        cur = head;
        while (cur != null && cur != l2){
            preL2 = cur;
            cur = cur.next;
        }

        // if l1 does not exist
        if(preL1 != null) {
            if (preL1.next == null) {
                return head;
            }
        }

        // if l2 does not exist
        if (preL2!=null) {
            if (preL2.next == null) {
                return head;
            }
        }

        // L1 is head
        if (preL1 == null){
            ListNode temp = preL2.next;
            preL2.next = head;
            dummy.next = temp;
            return dummy.next;
        }

        // L2 is head
        if (preL2 == null){
            ListNode temp = preL1.next;
            preL1.next = head;
            dummy.next = temp;
            return dummy.next;
        }

        // if all exist.
        ListNode temp = preL1.next;
        preL1.next = preL2.next;
        preL2.next = temp;

        return head;
    }
}
