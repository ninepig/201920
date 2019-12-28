package company.oracle.onsiteMianjing;

import tree.TreeNode;

import java.util.Stack;

public class inorderTravel {
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

}
