package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by yangw on 2019/10/19.
 */
public class ReduntantConnection684 {

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return null;
        HashMap<Integer,LinkedList<Integer>> graph = new HashMap<>();

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            boolean hasPath = dfs(new ArrayList<Integer>(),graph, u , v);
            if (hasPath){
                return edge;
            }else {
                if (!graph.containsKey(u)){
                    graph.put(u, new LinkedList<>());
                }
                graph.get(u).add(v);

                if (!graph.containsKey(v)){
                    graph.put(v, new LinkedList<>());
                }
                graph.get(v).add(u);
            }
        }
        return null;
    }

    private boolean dfs(ArrayList<Integer> visited, HashMap<Integer, LinkedList<Integer>> graph, int u, int v) {
        if (!graph.containsKey(u) || !graph.containsKey(v)){
            return false;
        }
        if (u == v){
            return true;
        }
        visited.add(u);
        for (int neighbourNode : graph.get(u)){
            if (!visited.contains(neighbourNode)){
                if (dfs(visited,graph,neighbourNode,v)){
                    return true;
                }
            }
        }
        return false;
    }

    class uf{
        int[] parent;
        int[] rank;
        public uf(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            for ( int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
        }
        public boolean connect(int p , int q){
            return find(p) == find(q);
        }
        public int find(int p ){
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p , int q){
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;

            if (rank[rootP] > rank[rootQ]){
                parent[rootQ] = rootP ;
            }else{
                parent[rootP] = rootQ;
                if (rank[rootP] == rank[rootQ]){
                    rank[rootP]++;
                }
            }
        }
    }
    public int[] findRedundantConnection2(int[][] edges) {

        if (edges == null || edges.length == 0) return null;
        uf unionFind = new uf(edges.length);
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
           if (unionFind.connect(u,v)){
               return edge;
           }else {
               unionFind.union(u,v);
           }
        }
        return null;
    }

}