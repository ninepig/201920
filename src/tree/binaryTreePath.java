package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/6/23.
 */
public class binaryTreePath {
    // DC version
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        for (String path : left) {
            res.add(root.val + "->" + path);
        }
        for (String path : right) {
            res.add(root.val + "->" + path);
        }

        if (res.size() == 0) {
            res.add("" + root.val);
        }

        return res;
    }

    // Traversal version
    public List<String> binaryTreePathsTravel(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res,root,"");

        return res;

    }

    private void dfs(List<String> res, TreeNode root, String s) {
        if (root == null) return;
        if(root.left == null && root.right == null){
            res.add(s+root.val);
        }
        if(root.left!=null){
            dfs(res,root.left,s+root.val+"->");
        }
        if(root.right!=null){
            dfs(res,root.right,s+root.val+"->");
        }
    }
}