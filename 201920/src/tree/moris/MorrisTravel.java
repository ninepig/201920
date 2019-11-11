package tree.moris;

import tree.TreeNode;
/*
 * Morris inorder/preorder traversals
 * 阿三的视频
 * Time complexity O(n)
 * Space complexity O(1)
 */
public class MorrisTravel {

    public void inorder(TreeNode root){
        TreeNode current = root;
        while(current == null){
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

    public void morrisTravel(TreeNode root){
        TreeNode cur = root;

        if(cur.left == null){
            System.out.println(cur.left.val);
            cur = cur.right;
        }else{
            TreeNode predecessor = cur.left;
            while (predecessor.right != cur && predecessor.right != null){
                predecessor = predecessor.right;
            }
            if (predecessor.right == null){
                // inorder
                System.out.println(cur.val);
                predecessor.right = cur;
                cur = cur.left;
            }else{
                // preorder
                System.out.println(cur.val);
                predecessor.right = null;
                cur = cur.right;
            }
        }

    }
}
