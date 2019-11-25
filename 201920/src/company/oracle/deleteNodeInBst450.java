package company.oracle;

import tree.TreeNode;

/*
  1 if key bigger than root. it will on right
  2 if key smaller than root. it will be on left
  3 located:
     1 root.left is null. so we return right
     2 root.right is null. so we return left
     3 It has both sides. so we find the smallest one on after root.
     set the root value with small one. Remove that from right side.
 */
public class deleteNodeInBst450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (key < root.val){
            return deleteNode(root.left , key);
        }else if (key > root.val){
            return deleteNode(root.right , key);
        }else{
            if (root.left == null){
                return root.right;
            }else  if(root.right == null){
                return root.left;
            }
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root, root.val);
        }
        return root;
    }

    // Get the leftest node of bst
    private TreeNode findMin(TreeNode root) {
        if (root == null) return root;
        while (root!=null){
            root = root.left;
        }
        return root;
    }
}
