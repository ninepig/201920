package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/11/3.
 * https://leetcode.com/problems/redundant-connection-ii/discuss/108045/C%2B%2BJava-Union-Find-with-explanation-O(n)
 *Good explained !!
 * http://zxi.mytechroad.com/blog/graph/leetcode-685-redundant-connection-ii/
 */
public class RedunantConnectionII685 {
    public int[] findRedundantDirectedConnection(int[][] a) {
        Map<Integer, Integer> indegree = new HashMap<>();
        int OneNodeHasTwoParent = -1;
        // Count indegree edges for all nodes.
        for (int[] v : a){
            indegree.put(v[1],indegree.getOrDefault(v[1],0)+1);
            if (indegree.get(v[1]) == 2) OneNodeHasTwoParent = v[1];
        }

        if (OneNodeHasTwoParent  == -1){
            return findReduntantConnect(a,-1);
        }else{
            for (int i = a.length - 1 ; i >= 0 ; i--){
                if (a[i][1] == OneNodeHasTwoParent){
                    int[] res = findReduntantConnect(a, i);
                    if (res == null) return a[i];
                }
            }
        }
        return null;
    }

    private int[] findReduntantConnect(int[][] a, int skip) {
        UnionFind uf = new UnionFind(a.length);
        for (int i = 0; i < a.length; i++) {
            if (i == skip) continue;
            if (uf.union(a[i][0], a[i][1])) {
                return a[i];

            }
        }
        return null;

    }

    class UnionFind {
        int[] parent;
        int[] ranks;

        public UnionFind(int size) {
            parent = new int[size + 1];
            ranks = new int[size + 1];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                ranks[i] = 1;
            }
        }

        public int find(int node) {
            while (parent[node] != node) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }

        public boolean union(int node1, int node2) {
            int node1Parent = find(node1);
            int node2Parent = find(node2);
            if (node1Parent == node2Parent) return false;
            if (ranks[node1Parent] > ranks[node2Parent]) parent[node2Parent] = node1Parent;
            else if (ranks[node1Parent] < ranks[node2Parent]) parent[node1Parent] = node2Parent;
            else {
                parent[node1Parent] = node2Parent;
                ranks[node1Parent] += 1;
            }
            return true;
        }
    }



    Map<Integer, Integer> incoming = new HashMap<>();

    public int[] findRedundantDirectedConnection2(int[][] a) {

        // count incoming edges for all nodes
        int nodeWithTwoIncomingEdges = -1;
        for(int[] v : a){
            incoming.put(v[1], incoming.getOrDefault(v[1], 0)+1);
            if(incoming.get(v[1])==2) nodeWithTwoIncomingEdges=v[1];
        }

        if(nodeWithTwoIncomingEdges==-1){
            // if there are no nodes with 2 incoming edges -> just find a cycle
            return findRedundantConnection(a, -1);
        }else{
            // if there is a node with 2 incoming edges -> skip them one by one and try to build a graph
            // if we manage to build a graph without a cycle - the skipped node is what we're looking for
            for(int i=a.length-1;i>=0;i--){
                if(a[i][1]==nodeWithTwoIncomingEdges) {
                    int[] res = findRedundantConnection(a, i);
                    if(res==null) return a[i];
                }
            }
        }

        return null;
    }

    // 'Redundant Connection' solution is extended to skip a node.
    int[] findRedundantConnection(int[][] a, int skip){
        UnionFind2 uf = new UnionFind2();

        for(int i=0;i<a.length;i++){
            if(i==skip) continue;
            if(!uf.union(a[i][0], a[i][1])) return a[i];
        }

        return null;
    }

    class UnionFind2 {
        Map<Integer, Integer> map = new HashMap<>();

        int find(int x){
            if(!map.containsKey(x)) map.put(x, x);

            if(map.get(x)==x) return x;
            int par = find(map.get(x));
            map.put(x, par);
            return par;
        }

        boolean union(int x, int y){
            int px = find(x);
            int py = find(y);

            if(px==py) return false;
            map.put(px, py);
            return true;
        }
    }
}