package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangw on 2019/6/23.
 * 值得背诵的后序方法。 太巧妙了。
 */
public class postOrderTravel {
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(0,cur.val);
            // push the left first, because we add right to head at first, then left.
            // So it still will be left, right ,root order.
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
        }
        return res;
    }
}
