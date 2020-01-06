package subcategory.LinkedList;

import linkedlist.ListNode;

/**
 * Created by yangw on 2019/6/29.
 * 分步做。其实也不难。
 */
public class reverseKgroup {



    public ListNode reverseKgroup(ListNode head , int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy ;

        while(true){
            head = reverseK(head, k);
            if (head == null){
                break;
            }
        }
        return dummy.next;
    }
    // head -> n1 -> n2 ... nk -> nk+1
    // =>
    // head -> nk -> nk-1 .. n1 -> nk+1
    // return n1
    private ListNode reverseK(ListNode head, int k) {
        ListNode nk = head;
        // Move forward to kth node
        for (int i = 0 ; i < k ; i++){
            if (nk == null) return null;
            nk = nk.next;
        }
        // edge case
        if (nk == null) return null;

        ListNode n1 = head.next;
        ListNode nkNext = nk.next;

        // reverse from n1--- nk
        ListNode pre = null;
        ListNode cur = n1;
        while (cur != nkNext){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        // connect
        head.next = nk;
        n1.next = nkNext;

        return n1;
    }
}
