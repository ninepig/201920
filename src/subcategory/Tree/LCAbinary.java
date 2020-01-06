package subcategory.Tree;


import facebookprepare.TreeNode;

import java.util.ArrayList;

/**
 * Created by yangw on 2019/6/23.
 */
public class LCAbinary {

    // BST version
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return root;
        if(root.val >= p.val && root.val <= q.val){
            return root;
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor( root.right , p , q);
        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.left , p , q);
        }
        return root;
    }


    public TreeNode lca(TreeNode root, TreeNode node1 , TreeNode node2){
        if(root == null || root == node1 || root == node2) return root;

        TreeNode left = lca(root.left , node1, node2);
        TreeNode right = lca(root.right,node1,node2);


        // 分别在左边 和右边 找到了节点， 所以root 就是lca
        if(left!= null && right!=null){
            return  root;
        }
        //只有左边找到了， 那左边的节点就是lca
        if (left != null){
            return left;
        }
        // 同理可得
        if(right != null){
            return right;
        }
        return null;
    }


    // Give the common ancestor of all the deepest nodes of a tree：
    public TreeNodeS lowestCommonAncestor(TreeNodeS root){
        return dfs(root, 0).node;
    }

    private ResultType dfs(TreeNodeS root, int depth){
        if (root == null){
            return new ResultType(root, 0);
        }
        int maxDepth = 0;
        int count = 0;
        TreeNodeS maxDepthNode = null;

        for (TreeNodeS child : root.children){
            ResultType temp = dfs(child, depth);
            int tempDepth = temp.depth;
            if (tempDepth + 1 > maxDepth){
                maxDepth = tempDepth + 1;
                maxDepthNode = temp.node;
                count = 1;
            } else if (tempDepth + 1 == maxDepth){
                count++;
            }
        }

        if (count > 1){
            return new ResultType(root, depth);
        } else {
            return new ResultType(maxDepthNode, maxDepth);
        }
    }

}

class TreeNodeS{
    int val;
    ArrayList<TreeNodeS> children;//多叉树
    public TreeNodeS(int val){
        this.val = val;
        this.children = new ArrayList<>();
    }
}

class ResultType{
    TreeNodeS node; //返回的节点
    int depth; //以该返回节点为根的树里最深的节点的深度depth
    public ResultType(TreeNodeS node, int depth){
        this.node = node;
        this.depth = depth;
    }
}
