package company.oracle.onsiteMianjing;

import tree.TreeNode;

public class diameterOfTreeNode {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
            if ( root == null) return max;

            helper(root);

            return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(max, left + right);

        return Math.max(left , right) + 1;
    }
}
