package linkedlist;

import java.util.List;

/**
 * Created by yangw on 2019/6/29.
 * 这题就是一道很好的需要完全理解listNode指针的题
 * 保留dumnmyLEFT DUMMYRIGHT 作为anchor指针 left right 作为移动指针。
 */
public class partitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null ) return head;
        ListNode dummyLeft = new ListNode(0), dummyRight = new ListNode(0);
        dummyLeft.next = head;

        ListNode left = dummyLeft;
        ListNode right = dummyRight;

        while (head != null){
            if (head.val >= x){
                right.next =  head;
                right = right.next;
            }else{
                left.next = head;
                left = left.next;
            }
            head = head.next;
        }
        left.next = dummyRight.next;
        right.next = null;

        return dummyLeft.next;
    }
}
