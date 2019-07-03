package facebookprepare;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/1.
 */
public class falttenBinaryToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
            if(!stack.isEmpty()){
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
