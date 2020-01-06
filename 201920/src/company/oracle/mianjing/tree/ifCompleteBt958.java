package company.oracle.mianjing.tree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ifCompleteBt958 {
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

}
