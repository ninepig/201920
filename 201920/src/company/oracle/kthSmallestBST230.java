package company.oracle;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import tree.TreeNode;

import java.util.Stack;

/*
传统做法。
stack

 */
public class kthSmallestBST230 {
    public int kthSmallest(TreeNode root, int k) {

        if (root == null) return -1;
        int count = 0;
        TreeNode cur = root;
        Stack<TreeNode> s = new Stack<>();

        while (!s.isEmpty()||cur!=null){
            while (cur != null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            count++;
            if (count == k){
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }


    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallestTravel(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        traverse(root.left, k);
        count ++;
        if(count == k) result = root.val;
        traverse(root.right, k);
    }
}


