package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class buildTreeFromInOrderAndPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || preorder.length!=inorder.length){
            return null;
        }
        return helper(preorder,inorder,0,0,inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder,int pre_pos , int in_begin, int in_end){
        if(pre_pos >= preorder.length || in_begin > in_end) return null;
        TreeNode root = new TreeNode(preorder[pre_pos]);
        int i = in_begin;
        while(i <= in_end){
            if(inorder[i] == preorder[pre_pos]){
                break;
            }
            i++;
        }
        root.left = helper(preorder,inorder,pre_pos+1,in_begin,i-1);
        root.right = helper(preorder,inorder,pre_pos+(i-in_begin)+1,i+1,in_end);

        return root;
    }
}
