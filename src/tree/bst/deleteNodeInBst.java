package tree.bst;

/**
 * Created by yangw on 2019/6/27.
 * bst 只能用题海战术
 */
public class deleteNodeInBst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key){
            root.left = deleteNode(root.left,key);
        }else if (root.val < key){
            root.right = deleteNode(root.right,key);
        }else{
            // 对于当前节点是target key的三种情况。 一定要画图做
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right,root.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode right) {
        while (right.left != null){
            right = right.left;
        }
        return right;
    }
}