package facebookprepare;

/**
 * Created by yangw on 2019/7/1.
 */
public class ClosestBinarySearchTreeValue {
//    leetcode
//    Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//            Note:
//    Given target value is a floating point.
//    You are guaranteed to have only one unique value in the BST that is closest to the target.
//
//
//    这个题就是在bst 上找最近目标的数，
//    遍历一遍找即可。
//


    double min = Integer.MAX_VALUE;
    int closedValue;

    public int closestValue(TreeNode root, double target) {
        dfs(root,target);
        return closedValue;

    }

    private void dfs(TreeNode root, double target) {
        if(root==null){
            return;
        }
        if (Math.abs(root.val-target)<min){
            min = Math.abs(root.val-target);
            closedValue = root.val;
        }
        dfs(root.left,target);
        dfs(root.right,target);

    }
}
