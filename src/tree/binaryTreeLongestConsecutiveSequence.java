package tree;

/**
 * Created by yangw on 2019/6/24.
 * 298
 * d & C
 */
public class binaryTreeLongestConsecutiveSequence {
    int maxLength = 0;
    public int longestSequence(TreeNode root){
        if (root == null) return 0;
        helper(root);
        return  maxLength;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int subTreeLength = 1;
        if (root.left != null && root.val + 1 == root.left.val){
            subTreeLength = Math.max(subTreeLength,left + 1);
        }
        if(root.right != null && root.val + 1 == root.right.val){
            subTreeLength = Math.max(subTreeLength,right + 1);
        }

        if(subTreeLength > maxLength){
            maxLength = subTreeLength;
        }
        return subTreeLength;
    }


}
