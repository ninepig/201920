package company.oracle.onsiteMianjing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class courseScedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return false;
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for (int i = 0 ; i < prerequisites.length ; i++){
            map.add(new ArrayList<>());
        }
        int[] indegree = new int[prerequisites.length];
        for (int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            map.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < indegree.length ; i++){
            if (indegree[i] == 0){
                q.offer(i);
            }
        }
        int k = 0;
        while (!q.isEmpty()){
            int tempCourse = q.poll();
            for (int nextCourse : map.get(tempCourse)){
                if (--indegree[nextCourse] == 0){
                    q.offer(nextCourse);
                }
            }
            k++;
        }
        return  k == numCourses;
    }
}