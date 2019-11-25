package company.oracle;

import tree.TreeNode;

import java.util.*;

public class findDuplicateSubTree652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        helper(root, map, set);
        List<TreeNode> ret = new ArrayList<>(set);
        return ret;
    }

    private String helper(TreeNode root, Map<String, Integer> map, Set<TreeNode> set) {
        if (root == null) return "#";
        String left = helper(root.left, map, set);
        String right = helper(root.right, map, set);
        String curr = root.val + left + right;
        if (map.containsKey(curr) && map.get(curr) == null) {
            set.add(root);
            map.put(curr, 1);
        } else if (!map.containsKey(curr)) {
            map.put(curr, null);
        }
        return curr;
    }
}
