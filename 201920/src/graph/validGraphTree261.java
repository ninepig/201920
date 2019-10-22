package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yangw on 2019/10/22.
 * https://segmentfault.com/a/1190000005687907#articleHeader1
 * 这道题的本质就是无向图找环
 * 1 uf
 * 2 着色法
 */
public class validGraphTree261 {
    class UnionFind {
        private int[] father;
        private int count;
        public UnionFind(int n) {
            father = new int[n];
            count = n;
            for (int i = 0; i < n; i++){
                father[i] = i;
            }
        }
        public int count() {
            return this.count;
        }
        public int find(int p) {
            int root = father[p];
            while (root != father[root])
                root = father[root];
            //as long as we get here, root is the final dad
            while (p != root) {
                int tmp = father[p];
                father[p] = root;
                p = tmp;
            }
            return root;
        }
        public void union(int p, int q) {
            int fatherP = find(p);
            int fatherQ = find(q);
            if (fatherP != fatherQ) {
                father[fatherP] = fatherQ;
                count--;
            }
        }
    }
    public class Solution {
        public boolean validTreeUF(int n, int[][] edges) {
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges){
                int p = edge[0];
                int q = edge[1];
                if (uf.find(p) == uf.find(q))
                    return false;
                else
                    uf.union(p,q);
            }
            return uf.count() == 1;
        }
    }
    public boolean validTreeColoring(int n, int[][] edges) {
        HashSet<Integer> visited = new HashSet<Integer>();
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i=0; i<n; ++i)
            adjList.add(new ArrayList<Integer>());
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        if (hasCycle(-1, 0, visited, adjList))  // has cycle?
            return false;
        if (visited.size() != n) // is all connected?
            return false;
        return true;
    }

    private boolean hasCycle(Integer pred, Integer vertex, HashSet<Integer> visited, List<List<Integer>> adjList) {
        visited.add(vertex);  // current vertex is being visited
        for (Integer succ: adjList.get(vertex)) {  // successors of current vertex
            if (!succ.equals(pred)) {  // exclude current vertex's predecessor
                if (visited.contains(succ)) {
                    return true; // back edge/loop detected!
                }
                else  {
                    if (hasCycle(vertex, succ, visited, adjList)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
