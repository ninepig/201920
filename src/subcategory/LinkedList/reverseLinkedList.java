package subcategory.LinkedList;

import linkedlist.ListNode;

/**
 * Created by yangw on 2019/6/29.
 */
public class reverseLinkedList {
    public ListNode reverseI(ListNode head) {
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

    //     public ListNode reverseList(ListNode head) {
//      if(head==null||head.next==null){
//             return head;
//         }
//         //递归头结点的下一个节点
//         ListNode newHead = reverseList(head.next);
//         //头结点的下个节点的已经到了最后面，然后把他的下一个节点给新的头结点
//         head.next.next = head;
//         //head.next 设为空就可以
//         head.next = null;

    //         return newHead;
    public ListNode reverseListRange(ListNode head, int m, int n) {

        if (head == null || m > n){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1 ; i < m ;i++){
            //  we need judge exist depends on the requirment
            if (head == null) return null;
            head = head.next;
        }

        ListNode preMNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, nNodePost = mNode.next;

        // 从mNode 后一个开始不断地和前面反转，最后把mNode接在尾巴上
        for (int i = m ; i < n ;i++){
            if (nNodePost == null) return null;
            ListNode temp = nNodePost.next;
            nNodePost.next = nNode;
            nNode = nNodePost;
            nNodePost = temp;
        }

        mNode.next = nNodePost;
        preMNode.next = nNode;

        return dummy.next;
    }
}
