package graph.bfs;

import java.util.*;

/**
 * Created by yangw on 2019/6/28.
 * 这道题是lintcode 原题，但是思路和leetcode numbers of connected component 差不多
 * 1 bfs
 * 2 union find ,这道题用uf 就不方便了， 方便的是leetcode那道返回数量的
 */
public class connectedComponent {
    class UndirectedGraphNode {
        int label;
        ArrayList<searchGraphNode.UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x; neighbors = new ArrayList<searchGraphNode.UndirectedGraphNode>();
        }
    }
    public ArrayList<ArrayList<UndirectedGraphNode>> bfs(ArrayList<UndirectedGraphNode> nodes){
        if (nodes == null || nodes.size() == 0) return null;
        ArrayList<ArrayList<UndirectedGraphNode>> res = new ArrayList<>();
        HashSet<UndirectedGraphNode> visted = new HashSet<>();

        for (UndirectedGraphNode node : nodes){
            if (!visted.contains(node)){
                bfs(res,node,visted);
            }
        }
        return res;

    }

    private void bfs(ArrayList<ArrayList<UndirectedGraphNode>> res, UndirectedGraphNode node, HashSet<UndirectedGraphNode> visted) {
        ArrayList<UndirectedGraphNode> cur = new ArrayList<>();
        Queue<UndirectedGraphNode> q = new ArrayDeque<>();
        q.offer(node);
        cur.add(node);
        visted.add(node);

        while (!q.isEmpty()) {
            UndirectedGraphNode c = q.poll();
            for (UndirectedGraphNode neigh : c.neighbors) {
                if (!visted.contains(neigh)) {
                    q.offer(neigh);
                    visted.add(neigh);
                    cur.add(neigh);
                }
            }
        }
        res.add(cur);
    }


    public int countComponents(int n, int[][] edges) {
        int count = n;

        int[] root = new int[n];
        // initialize each node is an island
        for(int i=0; i<n; i++){
            root[i]=i;
        }

        for(int i=0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];

            int xRoot = getRoot(root, x);
            int yRoot = getRoot(root, y);

            if(xRoot!=yRoot){
                count--;
                root[xRoot]=yRoot;
            }

        }

        return count;
    }

    public int getRoot(int[] arr, int i){
        while(arr[i]!=i){
            arr[i]= arr[arr[i]];
            i=arr[i];
        }
        return i;
    }
}
