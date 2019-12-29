package company.oracle.mianjing.tree;

public class bstToDlinkedList {
    class Node{
        Node left , right ;
        int val ;
        Node(int val , Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Node pre ;
    Node head ;
    public Node bstToDlinkedList(Node root){
        if (root == null) return root;
        pre = null;
        head = null;
        inorderHelper(root);

        pre.right = head;
        head.left = pre;
        return head;

    }

    private void inorderHelper(Node root) {
        if (root == null) return;
        inorderHelper(root.left);

        Node cur = new Node(root.val,null , null);
        if (head == null){
            head = cur;
        }
        if (pre != null){
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;

        inorderHelper(root.right);
    }

}
