package tree;

import java.util.Stack;

public class ValidateBST98 {
    /*
    要考虑比左边大，比右边小 这两种情况同时满足。
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    TreeNode pre = null;
    public boolean isValidBSTIt(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (!s.isEmpty() || cur != null){
            while (cur!=null){
                s.push(cur);
                cur = cur.left;
            }

            cur = s.pop();
            if (pre != null && pre.val >= cur.val){
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }

}
