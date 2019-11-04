package graph;

import java.util.*;

/**
 * Created by yangw on 2019/11/3.
 * https://www.cnblogs.com/Dylan-Java-NYC/p/11349641.html
 * Given the edges of a directed graph, and two nodes source and destination of this graph, determine whether or not all paths starting from source eventually end at destination, that is:

 At least one path exists from the source node to the destination node
 If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
 The number of possible paths from source to destination is a finite number.
 Return true if and only if all roads from source lead to destination.



 Example 1:



 Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
 Output: false
 Explanation: It is possible to reach and get stuck on both node 1 and node 2.
 Example 2:



 Input: n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
 Output: false
 Explanation: We have two possibilities: to end at node 3, or to loop over node 1 and node 2 indefinitely.
 Example 3:



 Input: n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
 Output: true
 Example 4:



 Input: n = 3, edges = [[0,1],[1,1],[1,2]], source = 0, destination = 2
 Output: false
 Explanation: All paths from the source node end at the destination node, but there are an infinite number of paths, such as 0-1-2, 0-1-1-2, 0-1-1-1-2, 0-1-1-1-1-2, and so on.
 Example 5:



 Input: n = 2, edges = [[0,1],[1,1]], source = 0, destination = 1
 Output: false
 Explanation: There is infinite self-loop at destination node.
 Note:

 The given graph may have self loops and parallel edges.
 The number of nodes n in the graph is between 1 and 10000
 The number of edges in the graph is between 0 and 10000
 0 <= edges.length <= 10000
 edges[i].length == 2
 0 <= source <= n - 1
 0 <= destination <= n - 1
 */
public class AllPathFromSourceLeadToDestination1059 {
    /*
       BFS with indegree way to do that.
       don't need topo way to do this.
     */
    public boolean leadsToDestination(int n , int[][] edges , int source , int destination){
        Map<Integer , HashSet<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[n];
        for (int i = 0 ; i < n ; i++){
            graph.put(i , new HashSet<Integer>());
        }

        for (int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            indegrees[edge[1]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        queue.offer(source);

        while (!queue.isEmpty()){
            int cur = queue.poll();
            // no more neighbour, and it is not the destintation.
            if (graph.get(cur).size() == 0 && cur != destination){
                return false;
            }

            // if indegree is less than 0, it means it has infiniti loop.
            for (int nei : graph.get(cur)){
                if (indegrees[nei] < 0){
                    return false;
                }
                indegrees[nei]--;
                queue.add(nei);
            }
        }
        return true;
    }

    class Solution {
        // DFS + coloring method
        public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
            Set<Integer> [] graph = new Set[n];
            for(int i = 0; i<n; i++){
                graph[i] = new HashSet<Integer>();
            }

            for(int [] edge : edges){
                graph[edge[0]].add(edge[1]);
            }

            return dfs(source, destination, graph, new int[n]);
        }

        private boolean dfs(int cur, int destination, Set<Integer>[] graph, int [] visited){
            if(visited[cur] != 0){
                return visited[cur] == 2;
            }

            if(graph[cur].size() == 0){
                return cur == destination;
            }

            visited[cur] = 1;
            for(int nei : graph[cur]){
                if(!dfs(nei, destination, graph, visited)){
                    return false;
                }
            }

            visited[cur] = 2;
            return true;
        }
    }
}
