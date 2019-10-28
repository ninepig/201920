package graph.graph.exersice.round2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yangw on 2019/10/27.
 */
public class courseSchedule209210 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){
            return false;
        }
        // Direct Graph
        List<List<Integer>> map = new ArrayList<>();
        int[] indegree = new int[prerequisites.length];

        for (int i = 0 ; i < numCourses ; i++){
            map.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            map.get(u).add(v);
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < indegree.length;i++){
            if (indegree[i] == 0){
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int neigh : map.get(cur)){
                if(--indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
            count++;
        }
        return  count == numCourses;
    }

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