package company.oracle;

import tree.TreeNode;

import java.util.Stack;

/*
利用一个current Node 和 stack 结合 即可解决问题。
利用current node 来维持当前node 的pointer。
 */
public class BSTIterator173 {

    TreeNode current;
    Stack<TreeNode> stack;

    public BSTIterator173(TreeNode root) {
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