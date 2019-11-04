package graph.graph.exersice.round2;

public class wenjingUf {
    class uf{
        int[] parent;
        int[] rank;
        int count;

	public uf( int n){
        this.parent = new int[n + 1];
        this.rank = new int[n + 1];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

	public int find( int p){
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

        public void union ( int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else {
            parent[rootP] = rootQ;
            rank[rootP] += 1;
        }
        count--;
    }

        public boolean isConnected ( int p, int q){
        return find(p) == find(q);
    }

        public int getCount () {
        return this.count;
    }
    }
}
