package tree;

import java.util.LinkedList;
import java.util.Queue;

public class isSameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left , q.left) && isSameTree(p.right, q.right);
    }
    /*
    连续两个节点的比较。 不是层序
     */
    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
            if(p == null  && q == null) return true;
            if (p == null || q == null) return false;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(p);
            queue.offer(q);
            while (!queue.isEmpty()){
                TreeNode first = queue.poll();
                TreeNode second = queue.poll();
                if (first == null || second == null ){
                    return false;
                } else if (first.val != second.val){
                    return false;
                } else{
                    queue.offer(first.left);
                    queue.offer(second.left);
                    queue.offer(first.right);
                    queue.offer(second.right);
                }
            }
            return true;
    }

}
