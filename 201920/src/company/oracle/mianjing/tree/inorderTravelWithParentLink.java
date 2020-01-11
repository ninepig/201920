package company.oracle.mianjing.tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTravelWithParentLink {
    public void inorderTravelStack(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (!s.isEmpty() || cur != null){
            while (cur!=null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }
    public void inorderTravelRecrusive(TreeNode root){
        if (root == null) return;
        inorderTravelRecrusive(root.left);
        System.out.println(root.val);
        inorderTravelRecrusive(root.right);
    }

    //https://www.geeksforgeeks.org/inorder-non-threaded-binary-tree-traversal-without-recursion-or-stack/
    class Node{
        int val;
        Node left, right , parent;
        public Node(int val){
            this.val = val;
            left = right = parent = null;
        }
    }
    /*
          10
         5  100
            80  120
        5  10 80 100  120
     */
    public void inorderTravelWithParentLink(Node root){
        boolean leftDone = false;
        while (root != null){
            if (!leftDone){
                // Get leftest node
                while (root.left!=null){
                    root = root.left;
                }
            }
            System.out.println(root.val);

            // Mark left is done
            leftDone = true;

            // if right child exist , get right node.
            if (root.right != null){
                leftDone = false;
                root = root.right;
            }// if right doesnot exit , move to parent
            else if(root.parent != null){
                // if node is parent 's right child node, we need go to parent 's parent.
                while (root.parent != null && root == root.parent.right){
                    root = root.parent;
                }

                if (root.parent == null){
                    break;
                }
                root = root.parent;
            }else {
                // No parent means we reach the root.
                break;
            }
        }
    }


    public List<Integer> inorderTravelWithParentLink2(Node root){
        List<Integer> res = new ArrayList<>();
        if (res == null) return res;
        Node cur = root;
        boolean leftDone = false;
        while (cur != null){
            if (!leftDone) {
                while (cur.left != null) {
                    cur = cur.left;
                }
            }
            leftDone = true;
            res.add(cur.val);
            if (cur.right != null){
                cur = cur.right;
                leftDone = false;
            }else if (cur.parent != null){
                // If have go through all right tree. Go UPPER
                while (cur.parent != null && cur.parent.right == cur){
                        cur = cur.parent;
                }
                if (cur.parent == null){
                    break;
                }
                cur = cur.parent;
            }else {
                // if there is no parent node ,  mean it back to root.
                break;
            }
        }
        return res;
    }
}
