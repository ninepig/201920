package company.oracle.mianjing.tree;

import tree.TreeNode;

/*
 * Morris inorder/preorder traversals
 * 阿三的视频
 * Time complexity O(n)
 * Space complexity O(1)
 * https://www.youtube.com/watch?v=wGXB9OWhPTg
 */
public class MorrisTravel {

    public void inorder(TreeNode root){
        TreeNode current = root;
        while(current != null){
            // Left is null , then print the node and go to right
            if (current.left == null){
                System.out.println(current.val);
                current = current.right;
            }else {
                // find the predecessor
                TreeNode predecssor = current.left;

                // To find predecssor , keep going right till right node is null.
                while (predecssor.right != current && predecssor.right != null){
                    predecssor = predecssor.right;
                }

                // if right node is null , then go left , and link the predecssor to the current node.
                if (predecssor.right == null){
                    predecssor.right = current;
                    current = current.left;
                }else {
                    // Print this predecssor , delte the link . And go right
                    // it means we have a link back to the previous root.
                    predecssor.right = null;
                    System.out.println(current.val +" ");
                    current = current.right;
                }
            }
        }
    }

    public void preOrder(TreeNode root){
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.println(current.val);
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    // 连线的时候把 root print 出来。 从而preorder
                    System.out.println(current.val);
                    // 往左走
                    current = current.left;
                } else {
                    // 断连。 走右侧
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

    public void inorderMorris(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                // Finding Predeccsor
                TreeNode predeccsor = cur.left;
                // Predeccsor has not link with cur and find rightest one.
                while (predeccsor.right != cur && predeccsor.right != null) {
                    predeccsor = predeccsor.right;
                }
                // Has not linked to cur.
                if (predeccsor.right == null) {
                    predeccsor.right = cur;
                    // Move to left.
                    cur = cur.left;
                } else {
                    // It realize we already have link here , it means , we already visited left node
                    // So we move the predccosr's link.  Visited Cur Node. Move to right node
                    predeccsor.right = null;
                    System.out.println(cur.val);

                    cur = cur.right;
                }
            }
        }
    }
        public void preorderMorris2(TreeNode root){
            if (root == null) return;
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left == null){
                    System.out.println(cur.val);
                    cur = cur.right;
                }else {
                    TreeNode predesscor = cur.left;

                    // No link and has right child
                    while (predesscor.right != null && predesscor.right!=cur){
                        predesscor = predesscor.right;
                    }

                    if (predesscor.right == null){
                        predesscor.right = cur;
                        System.out.println(cur.val);
                        cur = cur.left;
                    }else {
                        predesscor.right = null;
                        cur = cur.right;
                    }
                }
        }
    }
}
