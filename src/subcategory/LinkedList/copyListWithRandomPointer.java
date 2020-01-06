package subcategory.LinkedList;

import java.util.HashMap;

/**
 * Created by yangw on 2019/7/1.
 */
public class copyListWithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node dummy =  new Node(0);
        Node pre = dummy;
        Node newHead = null;
        HashMap<Node,Node> map = new HashMap();

        while(head != null){
            if(map.containsKey(head)){
                newHead = map.get(head);
            }else{
                newHead = new Node(head.val);
                map.put(head, newHead);
            }

            if(head.random != null){
                if(map.containsKey(head.random)){
                    newHead.random = map.get(head.random);
                }else{
                    newHead.random = new Node(head.random.val);
                    map.put(head.random,newHead.random);
                }
            }
            pre.next = newHead;
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;

    }

    public Node copyRandomList2(Node head) {
        Node iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }
}
