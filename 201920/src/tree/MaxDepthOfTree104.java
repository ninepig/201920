package tree;

/*
 similar to 110 balanced Tree.
 similar to 111
 Get Height
 */
public class MaxDepthOfTree104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }


    // Pattern .  helper to go through the whole tree. set global value .
    boolean ifTrue = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return ifTrue;

        helper(root);

        return ifTrue;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right ==null) return 1;

        int left = helper(root.left);
        int right = helper(root.right);

        if(Math.abs(left - right) > 1){
            ifTrue = false;
        }

        return Math.max(left, right) + 1;
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null){
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
