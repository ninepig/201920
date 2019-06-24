package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yangw on 2019/6/23.
 */
public class inOrderTravel {
    // 核心思想 ， 加到最左的子node, 然后popout，以此类推， 类似递归的思想。只不过用while循环展示了
    public ArrayList<Integer> preOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            // Add all the left node
            while (cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
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

        dfsTraversal(root.left, res);
        res.add(root.val);
        dfsTraversal(root.right, res);
    }

    public ArrayList<Integer> preOrderDc(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayList<Integer> left = preOrderDc(root.left);
        ArrayList<Integer> right = preOrderDc(root.right);

        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        return res;
    }
}
