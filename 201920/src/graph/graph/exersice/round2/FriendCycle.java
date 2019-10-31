package graph.graph.exersice.round2;

/**
 * Created by yangw on 2019/10/29.
 */
public class FriendCycle {
    class UF{
        int[] parent ;
        int[] rank;
        int count;
        public UF(int n ){
            parent = new int[n];
            count = n;
            for (int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
            rank = new int[n];
        }
        public int find(int p){
            while (p != parent[p]){
                p = parent[p];
                parent[p] = parent[parent[p]];
            }
            return p;
        }

        public void union(int p , int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootP] > rank[rootQ]){
                parent[rootQ] = rootP;
            }else{
                rank[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]){
                    rank[rootP]++;
                }
            }
            count--;
        }
        public boolean connected(int p , int q){
            return find(p) == find(q);
        }
        public int getCount(){
            return count;
        }
    }
    public int findCircleNumUf(int[][] M) {
        if (M == null || M.length == 0) return 0;
        UF uf = new UF(M.length);
        for (int i = 0 ; i < M.length - 1; i++){
            for (int j = i + 1 ; j < M.length ; j++){
                if (M[i][j] == 1) uf.union(i,j);
            }
        }
        return uf.getCount();
    }

    public int friendCycleNumDfs(int[][] M){
        if (M == null || M.length == 0) return 0;
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0 ; i < M.length ; i++){
            if (visited[i] == 0){
                dfs(visited,M,i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[] visited, int[][] m, int i) {
        for (int j = 0 ; j < m.length ;j++){
            if (visited[j] == 0 && m[i][j] == 1){
                visited[j] = 1;
                dfs(visited , m , j);
            }
        }
    }
}