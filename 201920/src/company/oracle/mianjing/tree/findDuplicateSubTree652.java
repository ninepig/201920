package company.oracle.mianjing.tree;

import tree.TreeNode;

import java.util.*;

public class findDuplicateSubTree652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
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


    public TreeNode removeDuplicatedSubStress(TreeNode root){
        if (root == null) return root;

        // First step, find all duplicated Tree
        // Remove

        Map<String , Integer> map = new HashMap<>();
        Set<TreeNode> duplicatedNode = new HashSet<>();
        helper2(duplicatedNode,map,root);

        // Remove
        if (duplicatedNode.contains(root)){
            return null;
        }

        helper3(root, duplicatedNode);

        return root;
    }

    private void helper3(TreeNode root, Set<TreeNode> duplicatedNode) {
        if (duplicatedNode.contains(root.left)){
            root.left = null;
        }
        if (duplicatedNode.contains(root.right)){
            root.right = null;
        }
        helper3(root.left,duplicatedNode);
        helper3(root.right,duplicatedNode);
    }

    private String helper2(Set<TreeNode> duplicatedNode, Map<String, Integer> map, TreeNode root) {
        if (root == null) return "#";
        String left = helper(root.left, map, duplicatedNode);
        String right = helper(root.right, map, duplicatedNode);
        String cur = root.val + left + right;
        if (map.containsKey(cur) && map.get(cur) == null) {
            duplicatedNode.add(root);
            map.put(cur, 1);
        } else if (!map.containsKey(cur)) {
            map.put(cur, null);
        }
        return cur;
    }
}
