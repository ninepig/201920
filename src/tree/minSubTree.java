package tree;

/**
 * Created by yangw on 2019/6/23.
 *  * dc + traversal
 */
public class minSubTree {
    int sum = 0;
    TreeNode res  ;
    public TreeNode findSubtree(TreeNode root) {
        if (root == null){
            return root;
        }
        res = null;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int val = root.val + helper(root.left) + helper(root.right);
        if(val < sum){
            sum = val;
            res = root;
        }
        return val;
    }


    class ResultType {
        public TreeNode minSubtree;
        public int sum, minSum;
        public ResultType(TreeNode minSubtree, int minSum, int sum) {
            this.minSubtree = minSubtree;
            this.minSum = minSum;
            this.sum = sum;
        }
    }
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtreeRe(TreeNode root) {
        ResultType result = helperRe(root);
        return result.minSubtree;
    }

    public ResultType helperRe(TreeNode node) {
        if (node == null) {
            return new ResultType(null, Integer.MAX_VALUE, 0);
        }

        ResultType leftResult = helperRe(node.left);
        ResultType rightResult = helperRe(node.right);

        ResultType result = new ResultType(
                node,
                leftResult.sum + rightResult.sum + node.val,
                leftResult.sum + rightResult.sum + node.val
        );

        if (leftResult.minSum <= result.minSum) {
            result.minSum = leftResult.minSum;
            result.minSubtree = leftResult.minSubtree;
        }

        if (rightResult.minSum <= result.minSum) {
            result.minSum = rightResult.minSum;
            result.minSubtree = rightResult.minSubtree;
        }

        return result;
    }
    

}