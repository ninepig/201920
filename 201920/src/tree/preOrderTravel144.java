package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preOrderTravel144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    public List<Integer> preorderTraversalNoneRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<Integer> systemStack = new Stack<>();
        Stack<TreeNode> paraStack = new Stack<>();

        systemStack.push(0);
        paraStack.push(root);

        while (!systemStack.isEmpty()) {
            int curline = systemStack.pop();
            TreeNode curPara = paraStack.peek();
            systemStack.push(curline + 1);

            if (curline == 0) {
                res.add(curPara.val);
            } else if (curline == 1) {
                if (curPara.left != null) {
                    systemStack.push(0);
                    paraStack.push(curPara.left);
                }
            } else if (curline == 2) {
                if (curPara.right != null) {
                    systemStack.push(0);
                    paraStack.push(curPara.right);
                }
            } else {
                systemStack.pop();
                paraStack.pop();
            }
        }
        return res;
    }

    public List<Integer> preorderTraversalSingleStack(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            res.add(cur.val);
            // reversed adding in to stack
            if (cur.right != null) s.push(cur.right);
            if (cur.left != null) s.push(cur.left);

        }
        return res;
    }
}




