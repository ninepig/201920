package company.oracle.mianjing.graph;

import java.util.*;

public class topoLogicalSorting {
    public List<Integer> topoSorting(int[][] edges , int N){
        ArrayList<Integer> res = new ArrayList<>();
        if (edges == null || edges.length == 0) return res;
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (int[] edge : edges){
            if (!map.containsKey(edge[0])){
                map.put(edge[0], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            indegree.put(edge[0],indegree.getOrDefault(edge[0],0)+1);
        }

        Queue<Integer> q  = new LinkedList<>();
        for (int i = 1 ; i <= N ;i++){
            if (!map.containsKey(i)){
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int cur = q.poll();
            res.add(cur);
            for (int next: map.get(cur)){
                indegree.put(next,indegree.get(next) - 1);
                if (indegree.get(next) == 0){
                    q.offer(next);
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}
