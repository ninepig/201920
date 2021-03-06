package tree;

/**
 * Created by yangw on 2019/6/23.
 * dc + traversal
 */
public class isBlancedTree {
    boolean isBalnced ;
    public boolean isBalanced(TreeNode root){
        if(root == null) return true;
        isBalnced = true;
        dfs(root);
        return isBalnced;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = dfs(root.left);
        int right= dfs(root.right);

        if(Math.abs(right - left) > 1){
            isBalnced = false;
        }
        return Math.max(left,right) + 1 ;
    }


    class ResultType {
        public boolean isBalanced;
        public int maxDepth;
        public ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }

     class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: True if this Binary tree is Balanced, or false.
         */
        public boolean isBalanced(TreeNode root) {
            return helper(root).isBalanced;
        }

        private ResultType helper(TreeNode root) {
            if (root == null) {
                return new ResultType(true, 0);
            }

            ResultType left = helper(root.left);
            ResultType right = helper(root.right);

            // subtree not balance
            if (!left.isBalanced || !right.isBalanced) {
                return new ResultType(false, -1);
            }

            // root not balance
            if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
                return new ResultType(false, -1);
            }

            return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
        }
    }
}
