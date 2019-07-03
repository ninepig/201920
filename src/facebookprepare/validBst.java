package facebookprepare;

import java.util.Stack;

/**
 * Created by yangw on 2019/6/30.
 */
public class validBst {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack();

        while(!stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
