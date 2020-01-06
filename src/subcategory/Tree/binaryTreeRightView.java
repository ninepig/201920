package subcategory.Tree;

import facebookprepare.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangw on 2019/7/5.
 */
public class binaryTreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i < size ; i++){
                TreeNode cur = q.poll();
                if (i == 0)res.add(cur.val);
                // 小细节，先加入右侧的
                if (cur.left != null) q.add(cur.right);
                if (cur.right != null) q.add(cur.left);
            }
        }
        return res;
    }

}
