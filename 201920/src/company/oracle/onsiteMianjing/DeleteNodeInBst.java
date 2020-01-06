package company.oracle.onsiteMianjing;

import tree.TreeNode;

public class DeleteNodeInBst {
    public TreeNode deleteNode(TreeNode root , int target){
        if (root == null) return root;
        if (root.val > target){
            deleteNode(root.left,target);
        }else if (root.val < target){
            deleteNode(root.right , target);
        }else {
            // 只要左侧为空 就返回右， 无论是不是leaf 节点。
            if (root.left == null){
                return root.right;
            }else  if(root.right == null){
                return root.left;
            } else {
                TreeNode temp = findMin(root);
                root.val = temp.val;
                // 这才对嘛。。把替换节点的val 删掉才可以！！
                root.right = deleteNode(root.right , root.val);
            }
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