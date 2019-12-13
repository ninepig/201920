package tree.difficult;

import tree.TreeNode;

import java.util.*;

public class allNodesToTargetWithDistanceK863 {

    Map<TreeNode, List<TreeNode>> graph ;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null) return new ArrayList<>();
        List<Integer> res= new ArrayList<>();
        buildMap(root,null);
        if (!graph.containsKey(target)) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        // missing something hashset!
        int distance = 0;
        while (!q.isEmpty()){
            int size = q.size();
            if (distance == K){
                for (int i = 0 ; i < size ; i++){
                    res.add(q.poll().val);
                }
            }
            for (int i = 0 ; i < size ; i++){
                TreeNode cur = q.poll();
                for (TreeNode neigh : graph.get(cur)){
                    // missing something
                    q.offer(neigh);
                }
            }
            distance++;
        }
        return res;
    }

    Map<TreeNode, List<TreeNode>> map = new HashMap();
//here can also use Map<TreeNode, TreeNode> to only store the child - parent mapping, since parent-child mapping is inherent in the tree structure

    public List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer> ();
        if (root == null || K < 0) return res;
        buildMap2(root, null);
        if (!map.containsKey(target)) return res;
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size ; i++) res.add(q.poll().val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            K--;
        }
        return res;
    }

    private void buildMap(TreeNode root, TreeNode parent) {
        if (root == null) return;
        if (!graph.containsKey(root)) {
            graph.put(root, new LinkedList<TreeNode>());
            if (parent != null) {
                // Parent must be in map already.
                graph.get(root).add(parent);
                graph.get(parent).add(root);
            }
            buildMap(root.left, root);
            buildMap(root.right, root);
        }
    }


    private void buildMap2(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<TreeNode>());
            if (parent != null)  { map.get(node).add(parent); map.get(parent).add(node) ; }
            buildMap2(node.left, node);
            buildMap2(node.right, node);
        }
    }
}