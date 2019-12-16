package company.oracle.mianjing.tree;

import sun.reflect.generics.tree.Tree;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class sameTree {
    public boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
    /*
    Has to use two stack to simulate the process.
     */
    public boolean isSameTreeBfs(TreeNode p, TreeNode q) {
        // iteration method
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.add(p);
        stackQ.add(q);
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode tmpP = stackP.pop();
            TreeNode tmpQ = stackQ.pop();
            if (tmpP.val != tmpQ.val) return false;
            if (tmpP.left != null && tmpQ.left != null) {
                stackP.push(tmpP.left);
                stackQ.push(tmpQ.left);
            } else if (tmpP.left == null && tmpQ.left == null) {
            } else {
                return false;
            }
            if (tmpP.right != null && tmpQ.right != null) {
                stackP.push(tmpP.right);
                stackQ.push(tmpQ.right);
            } else if (tmpP.right == null && tmpQ.right == null) {
            } else {
                return false;
            }
        }
        if (!stackP.isEmpty() || !stackQ.isEmpty()) return false;
        return true;

    }
}