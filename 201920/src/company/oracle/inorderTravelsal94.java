package company.oracle;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTravelsal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    public List<Integer> inorderTraversalNoneRecursive(TreeNode root) {
            if (root == null){
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            Stack<Integer> systemStack = new Stack<>();
            Stack<TreeNode> paraStack = new Stack<>();

            systemStack.push(0);
            paraStack.push(root);

            while(!systemStack.isEmpty()){
                int curline = systemStack.pop();
                TreeNode curPara = paraStack.peek();

                systemStack.push(curline + 1);
                if (curline == 0){
                    if (curPara.left != null){
                        systemStack.push(0);
                        paraStack.push(curPara.left);
                    }
                }else if (curline == 1){
                    res.add(curPara.val);
                }else if (curline == 2){
                    if (curPara.right != null){
                        systemStack.push(0);
                        paraStack.push(curPara.right);
                    }
                }else {
                    systemStack.pop();
                    paraStack.pop();
                }
            }
            return res;
    }

    // Inorder fix pattern
    public List<Integer> inorderTraversalSingleStack(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        // For this fixed judge statement.
        while(!s.isEmpty()||root!=null){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
