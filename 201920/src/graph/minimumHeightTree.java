package graph;

import java.util.*;

/**
 * Created by yangw on 2019/10/23.
 * 这是一道树的题，所以bfs 是用一层的那种方法
 * topo +bfs 淘汰法
 */
public class minimumHeightTree {
    public List<Integer> minimumHeightTrees(int n , int[][] edges){
        List<Integer> result = new ArrayList<>();
        if (n == 1){
            result.add(0);
            return  result;
        }
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0 ; i < n ; i++){
            graph.put(i,new ArrayList<>());
        }
        // Undirect graph
        for (int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < n ; i++){
            if (indegree[i] == 1){
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = list.size();
            for (int i = 0 ; i < size ; i++){
                int cur = q.poll();
                list.add(cur);
                for (int nei: graph.get(cur)){
                    indegree[nei]--;
                    if (indegree[nei] == 1) q.add(nei);
                }
            }
            result = list;
        }
        return result;
    }
}
