package graph.graph.exersice.round2;

/**
 * Created by yangw on 2019/10/27.
 */
public class UnionFindWithRank {
    int[] parent;
    int[] rank;
    int count;
    public UnionFindWithRank(int n){
        count = n;
        for (int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
    }

    public int find(int n){
        while (n != parent[n]){
            n = parent[n];
            parent[n] = parent[parent[n]];
        }
        return n;
    }

    public void union(int p , int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return ;
        if (rank[rootP] > rank[rootQ]){
            parent[rootQ] = rootP;
        }else {
            parent[rootP] = rootQ;
            if (rank[rootP] == rank[rootQ]){
                rank[rootP]++;
            }
        }
        count--;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int getCount(){
        return count;
    }

}
