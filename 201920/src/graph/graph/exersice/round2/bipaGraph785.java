package graph.graph.exersice.round2;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yangw on 2019/10/26.
 * 一定要看！ 这种题的判断结束条件，一旦出现一次就要return false，
 * 而全部都要出现没问题，才能返回true！ 这就是为啥中间返回false
 * 最终返回true的原因！ 因为false 是取一个反例即可。
 */
public class bipaGraph785 {
    public boolean isBipa(int[][] graph){
        if (graph == null || graph.length == 0) return false;
        
        int[] visit = new int[graph.length];
        for (int i = 0 ; i < graph.length ; i++){
            if (visit[i] == 0 && !dfsColor(graph,visit,1,i)){
                return false;
            }
        }
        return true;
    }
    // DFS ending condition is find cur's color and comparing to the color it previous color.
    /**
     *
     * @param graph
     * @param visit
     * @param color previous node's color
     * @param cur   current node index
     * @return
     */
    private boolean dfsColor(int[][] graph, int[] visit, int color, int cur) {
        // Ending condition
        if (visit[cur] != 0){
            // if same color , return true.
            return visit[cur] == color;
        }
        visit[cur] = color;
        for (int n : graph[cur]){
            if (dfsColor(graph,visit,-color,n)){
                return false;
            }
        }
        return true;
    }

    public boolean isBipaBFS(int[][] graph){
        if (graph == null || graph.length == 0) return false;

        int[] visited = new int[graph.length];
        for (int i = 0 ; i < graph.length ; i++){
            if (visited[i] == 0 && graph[i].length != 0){
                visited[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()){
                    int cur = q.poll();
                    for (int node : graph[cur]){
                        if (visited[node] == 0){
                            visited[node] = (visited[cur] == 1) ? -1 : 1;
                            q.offer(node);
                        }else {
                            if (visited[node] == visited[cur]) return false;
                        }
                    }
                }
            }
        }
        return  true;
    }
}
