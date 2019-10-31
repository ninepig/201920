package graph;

import java.util.ArrayList;

/**
 * Created by yangw on 2019/10/20.
 */
public class FriendCycle547 {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0 ; i < M.length ; i++){
            if (visited[i] == 0){
                dfs(M,visited, i);
                count++;
            }
        }
        return count;
    }

    // 找connection的过程，根据当前的student node，找和他connection的节点（学生），然后再连接到别的学生，dfs下去，直到把连接上所有的学生
    //然后循环找所有的学生，直到形成小岛（类似）
    //
    private void dfs(int[][] m, int[] visited, int student) {
        for (int i = 0 ; i < m.length ; i++){
            if (visited[i] == 0 && m[student][i] == 1){
                visited[i] = 1;
                dfs(m,visited,i);
            }
        }
    }
    class UnionFind{
        private int count = 0;
        private int[] parent , rank;

        public UnionFind(int n){
            // initial state
            // how many clusters
            count = n;
            parent = new int[n];
            rank = new int[n];
            // initial state: every node's parent is itself
            for (int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
        }

        public int findParent(int p ){
            // find it's parent and do path compression
            while (p != parent[p]){
                // Path compression by halving
                p = parent[p];
                parent[p] = parent[parent[p]];

            }
            return p;
        }

        public void union(int p , int q){
            int rootP = findParent(p);
            int rootQ = findParent(q);
            if (rootP == rootQ) return;
            if (rank[rootP]> rank[rootQ]){
                parent[rootQ] = rootP;
            }else {
                parent[rootP] = rootQ;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }
        public int count(){
            return count;
        }
    }

    public int findCircleNumUF(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }
}