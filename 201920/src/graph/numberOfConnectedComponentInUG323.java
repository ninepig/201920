package graph;

/**
 * Created by yangw on 2019/10/30.
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 Example 1:
 0          3
 |          |
 1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 Example 2:
 0           4
 |           |
 1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 Note:
 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */

/**
 * 标准的uf 方程， 但是不知道find里面这么写对不对。
 */
public class numberOfConnectedComponentInUG323 {
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return 0;
        int[] parent = new int[n];
        for (int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        int result = n;
        for (int[] edge : edges){
            int uRoot = find(parent , edge[0]);
            int vRoot = find(parent , edge[1]);
            if (vRoot != uRoot){
                parent[vRoot] = uRoot;
                result--;
            }
        }
        return  result;
    }

    private int find(int[] parent, int i) {
            while (parent[i] != i){
                i = parent[i];
                parent[i] = parent[parent[i]];
            }
            return i;
    }
}
