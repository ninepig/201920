package tree;

/**
 * Created by yangw on 2019/6/24.
 * 426 非常巧妙的方法。
 * 就是inorder
 */
public class bstToDlinklist {

    /**
     * here are two steps to solve this problem.
     * We use a dummy node to denote the head of the start of the double linked list.
     * Usin a global variable prev to denote the last node we visited. Using a helper which recursively in-order traversal the whole tree.
     * Linking prev and cur node together. After that, link tail node, which is prev and head node which is dummy.right.

     */

// Definition for a Node.
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
};
    class Solution {
        Node prev = null;
        public Node treeToDoublyList(Node root) {
            if (root == null){
                return null;
            }
            Node dummy = new Node(0, null, null);
            prev = dummy;
            helper(root);
            //connect tail with head;
            prev.right = dummy.right;
            dummy.right.left = prev;
            return dummy.right;
        }

        private void helper(Node cur){
            if (cur == null){
                return;
            }
            helper(cur.left);
            prev.right = cur;
            cur.left = prev;
            prev = cur;
            helper(cur.right);
        }
    }

}
