package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Similar to  103 107 . Skipped
 */
public class BinaryTreeOrderLevelTravel102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0 ; i < size ; i++){
                TreeNode curNode = q.poll();
                cur.add(curNode.val);
                if (curNode.left != null){
                    q.offer(curNode.left);
                }
                // we can not use else if !! need if !! have to go through this
                // TODO  go through Queue, it is not ifelse. it need to be if if if !!
                if (curNode.right != null){
                    q.offer(curNode.right);
                }
            }
            res.add(cur);
        }
        return res;
    }
}
