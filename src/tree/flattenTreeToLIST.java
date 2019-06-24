package tree;

import java.util.Stack;

/**
 * Created by yangw on 2019/6/23.
 */
public class flattenTreeToLIST {
    // 不太理解
    public void flattenTree(TreeNode root){
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) return root;

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if(left != null){
            left.right = root.right;
            root.right = left;
            root.left = null;
        }
        if(right != null){
            return right;
        }
        if(left != null){
            return left;
        }
        return root;
    }
    // 比较好理解， 对于当前点 把右边的先push 再左边。 然后connect
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            // connect
            node.left = null;
            if (stack.empty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }
}
