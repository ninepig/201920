package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class balancedTree {
    boolean isBa = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return isBa;
    }


    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left-right)>1){
            isBa = false;
        }
        return Math.max(left,right)+1;

    }

}
}
