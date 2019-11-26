package company.oracle;

public class BSTtoDoubleLinkedList426 {
    private Node pre, head ;
    public Node treeToDoublyList(Node root) {
        if (root == null) return  root;
        pre = null ;
        head = null;
        inorderHelper(root);
        pre.right = head;
        // Setting null.
        head.left = pre;

        return head;
    }

    // 过程很幽雅
    // 1 如果头结点为空， 那当前点就是头
    // 2 维护一个pre的节点，然后往右侧连，再连回去即可
    // 3 设置当前节点位pre节点
    private void inorderHelper(Node root) {
        if (root == null) return;
        inorderHelper(root.left);
        Node cur = new Node(root.val, null , null);
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
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}