package company.oracle;

import tree.TreeNode;

public class UnivaluedBinaryTree965 {
    Boolean flag = true;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return flag;
        helper(root);
        return flag;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.val != root.val){
            flag = false;
        }
        if (root.right != null && root.right.val != root.val){
            flag = false;
        }
        helper(root.left);
        helper(root.right);
    }
}
