package tree.difficult;

import java.util.LinkedList;
import java.util.Queue;

public class popingNextRightPointer116117 {

    // Queue's bfs method will use o(n) memory
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i < size ; i++){
                Node cur = q.poll();
                Node next = null;
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
    /*
     巧妙地背诵题。
     */
    public Node connectNoQueueForFullTree(Node root){
        Node start = root;
        while (start != null){
            Node cur = start;
            while (cur != null){
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.next != null && cur.right != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            start = start.left;
        }
    return root;
    }
    /*
    想象成一层即可
    每层多一个dummyNode。画图一想就明白。
     */
    public Node connectNoQeuueForNormalTree(Node root){
        Node cur = root;
        while(cur != null){
            Node tempChild = new Node(0);
            Node currentChild = tempChild;
            while(cur!=null){
                if(cur.left != null) { currentChild.next = cur.left; currentChild = currentChild.next;}
                if(cur.right != null) { currentChild.next = cur.right; currentChild = currentChild.next;}
                cur = cur.next;
            }
            cur = tempChild.next;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left, right, next;
    Node(int x) { val = x; }
 }