package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangw on 2019/6/23.
 */
public class preOrderTravel {
    public ArrayList<Integer> preOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.left != null) {
                stack.add(cur.left);
            }
            if (cur.right != null) {
                stack.add(cur.right);
            }
        }
        return res;
    }

    public ArrayList<Integer> preOrderTravsal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfsTraversal(root, res);
        return res;
    }

    private void dfsTraversal(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        dfsTraversal(root.left, res);
        dfsTraversal(root.right, res);
    }

    public ArrayList<Integer> preOrderDc(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayList<Integer> left = preOrderDc(root.left);
        ArrayList<Integer> right = preOrderDc(root.right);
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }


}
