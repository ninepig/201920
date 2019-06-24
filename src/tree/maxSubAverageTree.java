package tree;

/**
 * Created by yangw on 2019/6/23.
 * 给一棵二叉树，找到有最大平均值的子树。返回子树的根结点。
 * lintcode
 * resultType
 * 这道题类似minSubTree， 但是因为要return 2个参数来做全局的对比，所以要用一个额外的returntype来作为辅助
 */
public class maxSubAverageTree {
    private class resultType {

        int sum;
        int nodeNumber;
        resultType(int sum, int nodeNumber){
            this.sum = sum;
            this.nodeNumber = nodeNumber;
        }
    }

    private TreeNode subtree = null;
    private resultType subtreeResult = null;
    public TreeNode findMaxAverageSubtree(TreeNode root){
        if(root == null) return root;
        
        return subtree;
        
    }

    private resultType helper(TreeNode root) {
        if (root == null) return null;

        resultType left = helper(root.left);
        resultType right = helper(root.right);

        resultType cur = new resultType(left.sum + right.sum, left.nodeNumber + right.nodeNumber);

        if (cur.sum/cur.nodeNumber > subtreeResult.sum/subtreeResult.nodeNumber){
            subtreeResult = cur;
            subtree = root;
        }
        return cur;
    }
}
