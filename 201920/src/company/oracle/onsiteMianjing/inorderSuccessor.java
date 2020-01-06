package company.oracle.onsiteMianjing;

import tree.TreeNode;

import java.util.Stack;

public class inorderSuccessor {
    // Successor 是下一个比他大的 ， 而不是下一个节点的意思！
    // 所以用bst inorder来做 ， 如果有右侧节点，找这个右侧节点的最左子即可
    // 如果没有右侧结点， 则找他之前最小的比他大的即可。
    // bst 递归的方法要再想想。
    public TreeNode inorderSuccessorBst(TreeNode root , TreeNode target){
        if (root == null || target == null) return null;
        Stack<TreeNode> s =  new Stack<>();
        TreeNode cur = root;
        while (!s.isEmpty() || cur != null){
            while (cur!=null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (cur == target){
                if (cur.right!=null){
                    TreeNode m = cur.right;
                    while (m.left != null) {
                        m = m.left;
                    }
                    return m;
                }else if (!s.isEmpty()){
                    return s.pop();
                }
            }
            cur = cur.right;
        }
        return null;
    }

    public TreeNode inorderSuccssor(TreeNode root ,TreeNode target){
        if (root == null) return root;
        if (target.val >= root.val){
            TreeNode right = inorderSuccssor(root.right , target);
            return right;
        }else {
            // target it the left leafNode
            TreeNode left = inorderSuccssor(root.left, target);
            return left != null ? left : root;
        }
    }

    public TreeNode inorderPredessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }
        if (root.val >= p.val) {//利用BST性质
            TreeNode left = inorderPredessor(root.left, p);
            return left;
        } else {
            TreeNode right = inorderPredessor(root.right, p);//右叶，打印中叶或root
            return right != null ? right : root;
        }
    }
}
