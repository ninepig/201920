package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class increasingBst {
    class Solution {
        TreeNode pre, head = null;
        public TreeNode increasingBST(TreeNode root) {
            if(root == null){
                return null;
            }
            increasingBST(root.left);
            if(pre != null){
                root.left = null;
                pre.right = root;
            }
            // Record first node as headNode.
            if(head == null){
                head = root;
            }
            pre = root;
            increasingBST(root.right);
            return head;
        }
    }
}
