package tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/*
搞明白做法的一道题，就会很简单。首先肯定是从下往上的做法。subtree问题
然后就是分解问题。
 */
public class maxPathSum124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        if (root == null) return  0;

        helper(root);

        return max;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0,helper(node.left));
        int right = Math.max(0,helper(node.right));
        max = Math.max(max, left + right + node.val);

        return node.val + Math.max(left,right);
    }
}
