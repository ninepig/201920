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

}
