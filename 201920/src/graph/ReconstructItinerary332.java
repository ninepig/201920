package graph;

import java.util.*;

/**
 * Created by yangw on 2019/10/31.
 * 这道题就是一个有环有向图找路径的问题。找路径问题就是dfs。
 * 利用pq 来做排序，找到下一个应该去的机场。
 * 同时用dfs 模拟出栈！
 * nLogN
 */
public class ReconstructItinerary332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) return null;
        List<String> res = new ArrayList<>();
        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets){
            if (!graph.containsKey(ticket.get(0))){
                graph.put(ticket.get(0),new PriorityQueue<>());
            }
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs(graph,"JFK",res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String cur, List<String> res) {
        PriorityQueue<String> next = graph.get(cur);
        while (next!=null && !next.isEmpty()){
            dfs(graph,next.poll(),res);
        }
        res.add(0,cur);
    }
}
