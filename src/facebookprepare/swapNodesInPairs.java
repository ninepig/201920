package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class swapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null ) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next!=null&&cur.next.next!=null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
