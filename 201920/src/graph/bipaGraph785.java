package graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/6/30.
 * /**
 * Created by yangw on 2019/10/26.
 * 一定要看！ 这种题的判断结束条件，一旦出现一次就要return false，
 * 而全部都要出现没问题，才能返回true！ 这就是为啥中间返回false
 * 最终返回true的原因！ 因为false 是取一个反例即可。
 */
public class bipaGraph785 {
    public boolean isBipartite(int[][] graph) {
        //BFS
        // 0(not meet), 1(black), 2(white)
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0 && visited[i] == 0) {
                visited[i] = 1;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                while(! q.isEmpty()) {
                    int current = q.poll();
                    for (int c: graph[current]) {
                        if (visited[c] == 0) {
                            visited[c] = (visited[current] == 1) ? 2 : 1;
                            q.offer(c);
                        } else {
                            if (visited[c] == visited[current]) return false;
                        }
                    }
                }
            }
        }

        return true;
    }


    public boolean isBipartiteDfs(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {              //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
}
