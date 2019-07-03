package facebookprepare;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangw on 2019/6/30.
 */
public class btreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null ) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ;i < size;i++){
                TreeNode cur = q.poll();
                if(i == 0) res.add(cur.val);
                if(cur.right!=null) q.offer(cur.right);
                if(cur.left!=null)q.offer(cur.left);
            }
        }
        return res;
    }
}
