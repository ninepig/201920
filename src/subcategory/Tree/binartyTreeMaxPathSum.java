package subcategory.Tree;

import facebookprepare.TreeNode;

/**
 * Created by yangw on 2019/7/4.
 * Devide and couquer
 */
public class binartyTreeMaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left =  Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));

        max = Math.max(max,left+right+root.val);
        return root.val + Math.max(left,right);
    }
}
