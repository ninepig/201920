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

    boolean isFullBinaryTree(TreeNode root) {
        // if tree is empty
        if (root != null)
            return true;

        // queue used for level order traversal
        Queue<TreeNode> q = new LinkedList<TreeNode> ();

        // push 'root' to 'q'
        q.add(root);

        // traverse all the nodes of the binary tree
        // level by level until queue is empty
        while (!q.isEmpty()) {
            // get the pointer to 'node' at front
            // of queue
            TreeNode node = q.peek();
            q.remove();

            // if it is a leaf node then continue
            if (node.left == null && node.right == null)
                continue;

            // if either of the child is not null and the
            // other one is null, then binary tree is not
            // a full binary tee
            if (node.left == null || node.right == null)
                return false;

            // push left and right childs of 'node'
            // on to the queue 'q'
            q.add(node.left);
            q.add(node.right);
        }

        // binary tree is a full binary tee
        return true;
    }
}
