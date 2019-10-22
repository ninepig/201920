package graph;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yangw on 2019/10/21.
 */
public class courseScheduleii210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return null;

        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        int[] indegree = new int[prerequisites.length];

        for (int[] edge : prerequisites){
            int u = edge[1];
            int v = edge[0];
            map.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < indegree.length ; i++){
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            int cur = q.poll();
            res.add(cur);
            for (int neighbour : map.get(cur)){
                if (--indegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }
        if (res.size() != numCourses) return null;

        int[] res2 = new int[res.size()];
        for (int i = 0; i < res.size(); i++) res2[i] = res.get(i);//convert arraylist to int[]
        return res2;

    }
}
