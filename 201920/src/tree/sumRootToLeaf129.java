package tree;

import java.util.ArrayList;

/*
记忆题， 所有subtree的问题。 就是用从下到上的做法。别想有的没的。
 */
public class sumRootToLeaf129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) return  0;
        return helper(root, 0);
    }

    private int helper(TreeNode cur, int sum) {
        if (cur == null) return  0;
        int currentSum = 10 * sum + cur.val;
        if (cur.left == null && cur.right == null) return currentSum;
        // 一层一层算下去。
        int left = helper(cur.left , currentSum);
        int right = helper(cur.right, currentSum);
        return left + right;
    }
}
