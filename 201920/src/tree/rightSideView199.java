package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
level order ， 小trick， 先加最右侧的。这样到下一层，只需要取第一个即可。
 */
public class rightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null ) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
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
