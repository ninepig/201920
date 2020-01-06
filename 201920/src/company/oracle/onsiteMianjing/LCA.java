package company.oracle.onsiteMianjing;

import tree.TreeNode;

import java.util.List;

public class LCA {
    public TreeNode lcaOfTree(TreeNode root, TreeNode p , TreeNode q){
        if (root == p || root == q || root == null) return root;

        TreeNode left = lcaOfTree(root.left , p , q);
        TreeNode right = lcaOfTree(root.right, p , q);

        if (left!=null && right!=null) return root;
        if (left != null) return left;
        if (right != null) return right;

        return null;
    }

    public TreeNode lcaOfBST(TreeNode root, TreeNode p , TreeNode q){
        if (root == null) return  root;
        if (root.val < p.val && root.val < q.val){
            return lcaOfTree(root.left , p , q);
        }else if (root.val > p.val && root.val > q.val){
            return lcaOfTree(root.right, p , q);
        }else {
            return root;
        }
    }

    public mTreeNode LCAofMTree(mTreeNode root){
        return dfs(root, 0).node;
    }

    private ResultType dfs(mTreeNode root, int depth) {
        if (root == null) return new ResultType(root,depth);
        int max = 0;
        int count = 0;
        mTreeNode maxDepthNode = null;

        for (mTreeNode child : root.children){
            ResultType temp = dfs(child, depth);
            int tempDepth = temp.depth;
            if (tempDepth + 1 > max){
                max = tempDepth + 1;
                maxDepthNode = temp.node;
                count = 1;
            }else if (tempDepth + 1 == max){
                count++;
            }
        }

        if (count > 1){
            // Have mult children whose depth is deepest . so this root will be our target root.
            return new ResultType(root,depth);
        }else {
            // Have one or donot have.
            return  new ResultType(maxDepthNode ,max);
        }
    }

}

class mTreeNode{
    int val;
    List<mTreeNode> children;
}

class ResultType{
    int depth;
    mTreeNode node;
    ResultType(mTreeNode node , int depth){
        this.depth =depth;
        this.node =node;
    }
}

