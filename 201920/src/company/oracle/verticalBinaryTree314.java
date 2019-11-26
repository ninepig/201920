package company.oracle;

import sun.reflect.generics.tree.Tree;
import tree.TreeNode;

import java.util.*;

// todo treemap version is more niubi
public class verticalBinaryTree314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> vertical = new LinkedList<>();
        HashMap<Integer, ArrayList> path = new HashMap<>();
        q.offer(root);
        vertical.offer(0);
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int vIndex = vertical.poll();
            if (!path.containsKey(vIndex)) {
                path.put(vIndex, new ArrayList());
                path.get(vIndex).add(cur.val);
            }
            if (cur.left != null) {
                q.offer(cur.left);
                vertical.offer(vIndex - 1);
                if (min > vIndex - 1) {
                    min = vIndex - 1;
                }

            }
            if (cur.right != null) {
                q.offer(cur.right);
                vertical.offer(vIndex + 1);
                if (max < vIndex + 1) {
                    max = vIndex + 1;
                }
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(new ArrayList(path.get(i)));
        }
        return res;

    }

    // X is vIndex , y is depth
    public List<List<Integer>> verticalTraversal987(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    /*
    构建一个 每一列 | 每一层 - prirority Queue 的 大型的treeMap
    这样 每一列也是排序的 ， 每一层也是排序的
    这样打印的时候只要一个一个打出来即可。 真的太聪明了！！！！
     */
    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).offer(root.val);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }


    public List<List<Integer>> verticalTraversalTreeMap(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> graph = new TreeMap<>();
        dfs2(graph, 0 , 0 , root);
        for (TreeMap<Integer, PriorityQueue<Integer>> column : graph.values()){
            List<Integer> cur = new ArrayList<>();
            for (PriorityQueue<Integer> row : column.values()){
                while (!row.isEmpty()){
                    cur.add(row.poll());
                }
            }
            res.add(cur);
        }
        return res;
    }

    private void dfs2(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> graph, int vIndex, int depth, TreeNode root) {
        if (root == null) return;
        if (!graph.containsKey(vIndex)){
            graph.put(vIndex , new TreeMap<>());
        }
        if (!graph.get(vIndex).containsKey(depth)){
            graph.get(vIndex).put(depth, new PriorityQueue<>());
        }
        graph.get(vIndex).get(depth).add(root.val);
        dfs2(graph, vIndex - 1 , depth + 1 , root.left);
        dfs2(graph,vIndex + 1 , depth+1 , root.right);
    }
}
