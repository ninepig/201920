package facebookprepare;


import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/6/30.
 */
public class mergeKsortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        if(lists == null || lists.length == 0) return head;
        PriorityQueue<ListNode> minHeap =  new PriorityQueue<ListNode>(lists.length, (a , b) -> a.val - b.val);

        for(ListNode list : lists){
            if(list != null){
                minHeap.offer(list);
            }
        }

        while(!minHeap.isEmpty()){
            ListNode temp = minHeap.poll();
            head.next = temp;
            if(temp.next!=null){
                minHeap.offer(temp.next);
            }
            head = head.next;
        }
        return dummy.next;
    }
}
