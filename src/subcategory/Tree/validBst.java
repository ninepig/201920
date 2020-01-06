package subcategory.Tree;

import facebookprepare.TreeNode;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/4.
 */
public class validBst {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty() || root != null){
             while (root!=null){
                 s.push(root);
                 root = root.left;
             }
             root = s.pop();
             if (pre!=null && root.val < pre.val){
                 return false;
             }
             pre = root;
             root = root.right;
        }
        return true;
    }
}