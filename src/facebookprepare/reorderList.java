package facebookprepare;

/**
 * Created by yangw on 2019/7/1.
 */
public class reorderList {
    public void reorderList(ListNode head) {
     if(head==null||head.next==null){
        return ;
    }
    //find mid node
    ListNode mid = findMid(head);
    //reveser the right part
    ListNode halfHead = reverse(mid.next);
    mid.next = null;

    //merge two
    merge(head,halfHead);
}

    private void merge(ListNode head, ListNode halfHead) {
        ListNode dummy = new ListNode(0);
        int index = 0;
        while (head!=null&&halfHead!=null){
            if(index%2==0){
                dummy.next = head;
                head = head.next;
            }else {
                dummy.next = halfHead;
                halfHead = halfHead.next;
            }
            dummy = dummy.next;
            index++;
        }
        if(head!=null){
            dummy.next = head;
        }
        if(halfHead!=null){
            dummy.next = halfHead;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head!=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head,fast = head.next;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
