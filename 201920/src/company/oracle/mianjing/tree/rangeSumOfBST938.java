package company.oracle.mianjing.tree;

import tree.TreeNode;

/*
java 不能用值传递（基本类型）
要用全局变量， 如果我们要记录一个全局值。 只用object 可以用来做引用传递
 */
public class rangeSumOfBST938 {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L , R);
        return  sum;
    }

    private void helper(TreeNode root, int l, int r) {
        if (root == null) return;
        if (root.val <= r && root.val >= l){
            sum += root.val;
        }
        helper(root.left , l , r);
        helper(root.right , l , r);
    }
// 错误的，因为值传递的问题
//    public int rangeSumBST(TreeNode root, int L, int R) {
//        int sum = 0;
//
//        helper(sum, root, L , R);
//
//        return  sum;
//    }
//
//    private void helper(int sum, TreeNode root, int l, int r) {
//        if (root == null) return;
//        if (root.val <= r && root.val >= l){
//            sum += root.val;
//        }
//        helper(sum,root.left , l , r);
//        helper(sum, root.right , l , r);
//    }
}