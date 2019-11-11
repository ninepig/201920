package tree.difficult;

import tree.TreeNode;

import java.util.Stack;

/*
Reverse preorder 的一种做法。不可能做到inplace
用的就是递归
利用dummy Node 来做
死记硬背的题型

 */
public class flattenBTtoLinkedList114 {
    TreeNode pre = null;
    public void flatten(TreeNode root) {

        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;

        pre = root;
    }

    public void flattenStack(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        // Like dummy Node.
        TreeNode pre = new TreeNode(-1);
        s.push(root);
        while (!s.isEmpty()){
            TreeNode cur = s.pop();
            pre.right = cur;
            pre.left = null;
            if (cur.right != null) s.push(cur.right);
            if (cur.left != null) s.push(cur.left);
            pre = cur;
        }
    }
}
