package tree.bst;

/**
 * Created by yangw on 2019/6/27.
 * leetcode 701
 * 递归，这也就是想得到想不到的概念。
 */
public class insertNodeIntoBST {
    public TreeNode insertNode(TreeNode root, int val){
        if (root == null) return new TreeNode(val);
        if (root.val > val){
            root.left = insertNode(root.left,val);
        }else{
             root.right = insertNode(root.right,val);
        }
        return root;
    }
}
