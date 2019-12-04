package company.oracle;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class isSymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return helper(root.left , root.right);
    }
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return helper(left.left , right.right) && helper(left.right,right.left);
    }


    public boolean isSymmetircIteritive(TreeNode root){
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()){
            TreeNode first = q.poll();
            TreeNode second = q.poll();
            // need do this at first, other wise it will go to false!!
            if(first == null && second == null){
                continue;
            }else if(first == null || second == null){
                return false;
            }else if(first.val != second.val){
                return false;
            }
                q.offer(first.left);
                q.offer(second.right);
                q.offer(first.right);
                q.offer(second.left);

        }
        return true;
    }
}
