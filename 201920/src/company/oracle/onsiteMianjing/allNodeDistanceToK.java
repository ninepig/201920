package company.oracle.onsiteMianjing;

import sun.reflect.generics.tree.Tree;
import tree.TreeNode;

import java.util.*;

public class allNodeDistanceToK {

    // BFS 做这种题的时候 一定要用个set ，要不然会无限循环下去！
    // 层序找下去。 一定要在所有操作结束以后才++/--  也就是在while循环的最后操作， 然后再while中间判断
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (target == null) return res;
        HashMap<TreeNode , ArrayList<TreeNode>> map = new HashMap<>();
        buildMap(root , map , null);
        if (!map.containsKey(target)) return res;
        HashSet<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        set.add(target);
        int level = K;
        while (!q.isEmpty()){
            int size = q.size();
            if (level == 0){
                for (int i = 0 ; i < size ; i++){
                    res.add(q.poll().val);
                }
            }
            for (int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)){
                    if (set.contains(next))continue;
                    set.add(next);
                    q.add(next);
                }
            }
            level--;
        }
        return res;
    }

    private void buildMap(TreeNode root, HashMap<TreeNode, ArrayList<TreeNode>> map, TreeNode parent) {
        if (root == null) return;
        if (!map.containsKey(root)){
            map.put(root, new ArrayList<>());
            if (parent != null){
                map.get(root).add(parent);
                // Parent must be there.
                map.get(parent).add(root);
            }
            buildMap(root.left , map , root);
            buildMap(root.right , map , root);
        }
    }
}
