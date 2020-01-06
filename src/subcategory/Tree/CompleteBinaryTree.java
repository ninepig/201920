package subcategory.Tree;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/7/5.
 */
public class CompleteBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (true){
            TreeNode node = q.poll();
            if (node.left == null){
                if ( node.right != null){
                    return false;
                }
            }
            q.offer(node.left);
            if (node.right == null) break;
            q.offer(node.right);
        }
        // Just leave children in last level
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (node.left!=null || node.right!=null){
                return false;
            }
        }
        return true;
    }
}