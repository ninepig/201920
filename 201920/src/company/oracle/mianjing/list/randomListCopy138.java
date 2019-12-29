package company.oracle.mianjing.list;

import java.util.HashMap;
import java.util.Map;

public class randomListCopy138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node dummy = new Node(0);
        Node pre = dummy;
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(0);
        map.put(head, new Node(head.val));

        while (head != null) {
            if (map.containsKey(head)) {
                newHead = map.get(head);
            } else {
                newHead = new Node(head.val);
                map.put(head, newHead);
            }
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newHead.random = map.get(head.random);
                } else {
                    newHead.random = new Node(head.random.val);
                    map.put(head.random, newHead.random);
                }
            }
            pre.next = newHead;
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }


    public Node copyRandomListWithoutHashmap(Node head) {
        Node cur = head, next;

        // Copy curNode and attach that to the next of the cur Node.
        while (cur != null) {
            next = cur.next;

            Node curCopy = new Node(cur.val);
            cur.next = curCopy;
            curCopy.next = next;

            cur = next;
        }

        // Assign random pointer to copied point
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // Restore orignal list and get copied list
        cur = head;
        Node dummy = new Node(0);
        Node copy, copyIter = dummy;

        while (cur != null) {
            next = cur.next.next;

            // extract the copy
            copy = cur.next;
            copyIter.next = copy;
            copyIter = copy;

            //restore the orginal list
            cur.next = next;

            cur = next;
        }
        return dummy.next;
    }

    // 关键还是要用一个Dummy啊！
    public Node copyRandomList2(Node head) {
        if (head == null) return head;
        Map<Node, Node> map = new HashMap<>();

        map.put(head, new Node(head.val));
        Node dummy = new Node(0);
        Node pre = dummy;
        // newNode is just a reference
        Node newNode = new Node(0);

        while (head != null) {
            if (!map.containsKey(head)) {
                newNode = new Node(head.val);
                map.put(head, newNode);
            } else {
                newNode = map.get(head);
            }
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    newNode.random = new Node(head.random.val);
                    map.put(head.random, newNode.random);
                } else {
                    newNode.random = map.get(head.random);
                }
            }
            pre.next = newNode;
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }

    public Node copyRandomListWithoutHashmap2(Node head) {
        if (head == null) return head;

        // Copy new node and put it after each node
        Node cur = head;
        while (cur != null){
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        // Copy random
        cur = head;
        while (cur != null){
            if (cur.random != null){
                // 这句是关键。
                // 1-1' --2 -2` ---3---3`
                //如果1的random node 是3 那1’的random node 就是 1的random的next
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node dummy = new Node(0);
        Node copyPre = dummy;
        cur = head;
        while (cur != null){
            copyPre.next = cur.next;
            cur.next = cur.next.next;
            copyPre = copyPre.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}