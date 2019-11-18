package company.oracle;

import LinkedList.ListNode;

import java.util.PriorityQueue;

public class MergeKsortedList23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));

        for (ListNode listNode: lists){
            if(listNode != null){
                pq.offer(listNode);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            head.next = cur;
            if (cur.next != null){
                pq.offer(cur.next);
            }
            head = head.next;
        }
        return dummy.next;
    }
}
