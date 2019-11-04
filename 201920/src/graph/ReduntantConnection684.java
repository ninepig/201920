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

    class UnionFind{
        int[] parent;
        int[] ranks;

        public UnionFind(int size){
            parent = new int[size+1];
            ranks = new int[size+1];
            for(int i = 0 ; i < size ; i++){
                parent[i] = i;
                ranks[i] = 1;
            }
        }

        public int find(int node){
            while(parent[node] != node){
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        public boolean union(int node1 , int node2){
            int node1Parent = find(node1);
            int node2Parent = find(node2);
            if(node1Parent == node2Parent) return false;
            if(ranks[node1Parent] > ranks[node2Parent]) parent[node2Parent] = node1Parent;
            else if (ranks[node1Parent] < ranks[node2Parent] ) parent[node1Parent] = node2Parent;
            else{
                parent[node1Parent] = node2Parent;
                ranks[node1Parent] += 1;
            }
            return true;
        }
    }
    public int[] findRedundantConnection2(int[][] edges) {
        UnionFind set = new UnionFind(edges.length);
        for (int[] edge: edges){
            if(!set.union(edge[0],edge[1])){
                return edge;
            }
        }
        return new int[]{};
    }

}