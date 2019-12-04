package tree.difficult;

import tree.TreeNode;

/*
关键是画图做。
inorder 是必须的。 因为他可以定位左侧 右侧
preorder / post order 则可以定位头点
 */
public class buildBinaryTree105106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        return helperForPostAndIn(inorder, postorder, 0, inorder.length - 1 , postorder.length - 1);
    }

    private TreeNode helperForPostAndIn(int[] inorder, int[] postorder, int in_begin, int in_end, int post_pos) {
        if (post_pos < 0 || in_begin > in_end) return null;
        TreeNode root = new TreeNode(postorder[post_pos]);
        int i = in_begin;
        while(i <= in_end){
            if (inorder[i] == postorder[post_pos]) break;
            i++;
        }
        root.left = helperForPostAndIn(inorder, postorder , in_begin , i - 1 ,  post_pos - (in_end - i) - 1);
        root.right = helperForPreAndIn(inorder,postorder , i + 1 , in_end , post_pos - 1);
        return root;
    }

    public TreeNode buildTreePreAndIn(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return helperForPreAndIn(preorder,inorder,0,0,inorder.length - 1 );
    }

    private TreeNode helperForPreAndIn(int[] preorder, int[] inorder, int pre_pos, int in_begin, int in_end) {
        if (pre_pos > preorder.length || in_begin > in_end) return null;
        TreeNode root = new TreeNode(preorder[pre_pos]);
        int i = in_begin;
        while (i <= in_end){
            if (preorder[pre_pos] == inorder[i]){
                break;
            }
            i++;
        }
        root.left = helperForPreAndIn(preorder,inorder,pre_pos + 1 , in_begin, i - 1);
        root.right = helperForPreAndIn(preorder,inorder, pre_pos + (i - in_begin) + 1 , i + 1 ,in_end);
        return root;
    }
}