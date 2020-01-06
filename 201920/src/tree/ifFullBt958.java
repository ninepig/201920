package tree;

import java.util.Queue;
import java.util.LinkedList;
public class ifFullBt958 {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        boolean flag = false;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null) flag = true;
            else{
                if(flag) return false;
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return true;
    }


    TreeNode root;

    /* this function checks if a binary tree is full or not */
    boolean isFullTree(TreeNode node)
    {
        // if empty tree
        if(node == null)
            return true;

        // if leaf node
        if(node.left == null && node.right == null )
            return true;

        // if both left and right subtrees are not null
        // the are full
        if((node.left!=null) && (node.right!=null))
            return (isFullTree(node.left) && isFullTree(node.right));

        // if none work
        return false;
    }
}
