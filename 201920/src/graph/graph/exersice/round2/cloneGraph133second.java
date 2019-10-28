package graph.graph.exersice.round2;

import graph.CloneGraph133;

import java.util.*;

/**
 * Created by yangw on 2019/10/26.
 */
public class cloneGraph133second {
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
        if (node == null ) return node;
        HashMap<Node , Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList();
        Node newNode = new Node(node.val,new ArrayList<>());
        map.put(node,newNode);
        q.offer(node);
        while (!q.isEmpty()){
            Node n = q.poll();
            for(Node neighbour : n.neighbors ){
                if (!map.containsKey(neighbour)){
                    Node newNeighbour = new Node(neighbour.val,new ArrayList<>());
                    map.put(neighbour,newNeighbour);
                    q.offer(newNeighbour);
                }
                // 关键的一步， 新的节点的neighbour 都必须是从map里存储的新的node
                map.get(n).neighbors.add(map.get(neighbour));
            }
        }
        return map.get(node);
    }

    public Node cloneGraphDFS(Node node) {
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
