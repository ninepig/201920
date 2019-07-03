package facebookprepare;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/6/30.
 */
public class isCompleteBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.offer(root);
        while (true) {
            TreeNode node = bfs.poll();
            if (node.left == null) {
                if (node.right != null)
                    return false;
                break;
            }
            bfs.offer(node.left);
            if (node.right == null) break;
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();
            if (node.left != null || node.right != null)
                return false;
        }
        return true;
    }
}
