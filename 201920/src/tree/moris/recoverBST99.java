package tree.moris;

import tree.TreeNode;
/*
遍历的时候，利用一个prenode 来保存和之前节点比较的做法。在bst之中经常出现。
这个题 用递归的其实就应该是O(N)space了
 */
public class recoverBST99 {
    TreeNode lastNode = new TreeNode(Integer.MIN_VALUE);
    TreeNode biggerOne = null;
    TreeNode smallerOne = null;
    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        int tmp = biggerOne.val;
        biggerOne.val = smallerOne.val;
        smallerOne.val = tmp;
    }

    public void inorderTraverse(TreeNode root){
        if(root == null) return ;
        inorderTraverse(root.left);
        // 正确的应该大于
        if(biggerOne == null && root.val <= lastNode.val){
            biggerOne = lastNode;
        }
        if(biggerOne != null && root.val <= lastNode.val){
            smallerOne = root;
        }
        lastNode = root;
        inorderTraverse(root.right);
    }
}
