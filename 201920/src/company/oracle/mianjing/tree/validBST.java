package company.oracle.mianjing.tree;

import tree.TreeNode;

import java.util.Stack;

public class validBST {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root){
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (!s.isEmpty() || cur != null){
            while (cur!=null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (pre != null){
                // >= ? PROBLEM
                if (pre.val >= cur.val){
                    return false;
                }
            }
            // Dont forget this.
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}
