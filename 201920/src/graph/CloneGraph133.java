package graph;

import java.util.*;

/**
 * Created by yangw on 2019/10/20.
 */
public class CloneGraph133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        queue.offer(node);
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, newNode);
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node neighbor : n.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
                    queue.offer(neighbor);
                }
                // if exist, put n's neighbour from hashmap
                // Mistake i made. should be n  , not neighbour
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }
    private void dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return;
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);
        for (Node nei : node.neighbors) {
            dfs(nei, map);
            copy.neighbors.add(map.get(nei));
        }
    }

}