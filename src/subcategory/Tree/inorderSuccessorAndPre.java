package subcategory.Tree;

import tree.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/6/24.
 * 285
 * 有本办法 以及利用特性做的
 */
public class inorderSuccessorAndPre {
    // 贱招。
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        List<TreeNode> path = inOrder(root);
        int index = path.indexOf(p);
        return index == -1 || index == path.size() - 1 ? null : path.get(index + 1);
    }

    private List<TreeNode> inOrder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> left = inOrder(root.left);
        List<TreeNode> right = inOrder(root.right);
        result.addAll(left);
        result.add(root);
        result.addAll(right);
        return result;
    }

    // bst 特性
    public TreeNode inorderSuccessorBST(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (root.val <= p.val){
            return inorderSuccessorBST(root.right,p);
        }else {
            TreeNode left = inorderSuccessor(root.left,p);
            return left == null ? root : null;
        }
    }
}