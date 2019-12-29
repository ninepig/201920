package company.oracle.mianjing.list;

import LinkedList.ListNode;

public class mergeTwoSortedList {
    public ListNode mergeTwoList(ListNode l1 , ListNode l2){
        if (l1 == null ) return  l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null){
            if (l1.val >= l2.val){
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next =  l1 == null? l2 : l1;
        return dummy.next;
    }

    public ListNode mergeTwoListRercusive(ListNode l1 , ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoListRercusive(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoListRercusive(l1, l2.next);
            return l2;
        }
    }
}
