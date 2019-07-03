package facebookprepare;

import java.util.Stack;

/**
 * Created by yangw on 2019/6/30.
 */
public class bstIterator {
    TreeNode current;
    Stack<TreeNode> stack;

    public bstIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty())||(current!=null);
    }

    /** @return the next smallest number */
    public int next() {
        while (current!=null){
            stack.push(current);
            current = current.left;
        }
        TreeNode temp = stack.pop();
        current = temp.right;
        return temp.val;
    }
}
