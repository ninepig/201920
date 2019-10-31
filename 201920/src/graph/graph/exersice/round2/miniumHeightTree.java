package graph.graph.exersice.round2;

import java.util.*;


/**
 * Created by yangw on 2019/10/29.
 */
public class miniumHeightTree {
    public List<Integer> minimumHeightTrees(int n , int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 0 || edges == null ) return res;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for ( int i = 0 ; i < n ; i++){
            graph.put(i,new ArrayList<>());
        }

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
            int size = q.size();
            List<Integer> curRes = new ArrayList<>();
            for (int i = 0 ; i< size ; i++){
                int curNode = q.poll();
                // 很关键
                curRes.add(curNode);
                if (--indegree[curNode] == 1){
                    q.offer(curNode);
                }
            }
            res = curRes;
        }
        return res;
    }
}
