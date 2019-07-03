package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class maxMinDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        // if(root.left == null) return maxDepth(root.right);
        // if(root.right == null) return maxDepth(root.left);
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
