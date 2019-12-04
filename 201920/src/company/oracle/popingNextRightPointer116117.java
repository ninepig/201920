package company.oracle;

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val,Node2 _left,Node2 _right,Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class popingNextRightPointer116117 {
    public Node2 connect(Node2 root) {
        if (root == null) return root;
        Node2 cur = root;

        // Simulate a level order with dummy Node2 in each layer.
        while (cur != null){
            Node2 dummy = new Node2();
            Node2 curChidren = dummy;
            while (cur != null ){
                if (cur.left != null) {
                    curChidren.next = cur.left;
                    curChidren = curChidren.next;
                }
                if (cur.right != null){
                    curChidren.next = cur.right;
                    curChidren = curChidren.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }

        return root;
    }

    public Node2 connectLevel(Node2 root) {
        if(root == null) return root;
        Queue<Node2> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i < size ; i++){
                Node2 cur = q.poll();
                Node2 next = null;
                if (i < size - 1 ){
                    next = q.peek();
                }
                cur.next = next;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return root;
    }
}
