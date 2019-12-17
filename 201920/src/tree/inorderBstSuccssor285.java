package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yangw on 2019/12/16.
 */
public class inorderBstSuccssor285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)return root;
        Deque<TreeNode> st = new LinkedList<TreeNode>();
        TreeNode curr = root;
        // Find the target node while saving the path
        while(curr!=p){
            st.push(curr);
            if(curr.val > p.val){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        // if curr has right node, find the leftmost of right node(or itself), is the successor
        if(curr.right != null){
            curr = curr.right;
            while(curr.left != null){
                curr = curr.left;
            }
            return curr;
        }else{
            // if curr has no right node, find the 1st node in stack that val > curr.val
            while(!st.isEmpty()){
                if(st.peek().val>curr.val)return st.pop();
                st.pop();
            }
            // 如果栈都pop空了还没有比目标节点大的，说没有更大的了
            return null;
        }
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if(root == null){ return root;}
        if(root.val<=p.val){//利用BST性质
            TreeNode right = inorderSuccessor2(root.right,p);//successor in the right subtree
            return right;
        }else{
            TreeNode left = inorderSuccessor2(root.left,p);//looking for p in the left subtree
            return left != null?left:root;//null case: when leftmost leaf
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
