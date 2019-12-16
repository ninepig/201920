package company.oracle.mianjing.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangw on 2019/10/21.
 */
public class CourseSchudule209 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return false;
        int count = 0 ;
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        // Construct graph.
        for (int i = 0 ; i < prerequisites.length ; i++){
            map.add(new ArrayList<Integer>());
        }
        // 1 is the start point ,  0 is target point
        for (int[] edge : prerequisites){
            int u = edge[1];
            int v = edge[0];
            map.get(u).add(v);
            inDegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < inDegree.length ; i++){
            if (inDegree[i] == 0){
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int neighghbour : map.get(cur)){
                if (--inDegree[neighghbour]== 0){
                    q.offer(neighghbour);
                }
            }
            count++;
        }
        return count == numCourses;
    }
}
