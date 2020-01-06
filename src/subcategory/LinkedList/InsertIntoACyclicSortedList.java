package subcategory.LinkedList;

/**
 * Created by yangw on 2019/7/5.
 * corn case很多的一道题
 * 仔细仔细
 */
public class InsertIntoACyclicSortedList {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }
     public Node insert(Node head, int insertVal) {
       if (head == null) {
           Node newHead = new Node(insertVal,null);
           newHead.next = head;
           return newHead;
       }
        Node cur = head;
       while (true){
           if (cur.val < cur.next.val){
               // 上升阶段
               if (cur.val <= insertVal && insertVal<= cur.next.val){
                   cur.next = new Node(insertVal,cur.next);
                    break;
               }
               // 拐点
           }else if (cur.val>cur.next.val){
               if (cur.val <= insertVal||insertVal <= cur.next.val){
                   cur.next = new Node(insertVal,cur.next);
                   break;
               }
           }else {
               // alaways same , 11111
               if (cur.next == head){
                   cur.next = new Node(insertVal,cur.next);
               }
           }
        cur = cur.next;
       }
       return  head;
     }
}
