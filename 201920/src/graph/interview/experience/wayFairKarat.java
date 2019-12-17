package graph.interview.experience;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by yangw on 2019/11/12.
 */
public class wayFairKarat {

    class childParent{
        int val;
        List<childParent> parent;
        public childParent(int val){
            this.val = val;
        }
    }

    public static List<List<childParent>> findParentQuestionOne(int[][] edges){
        if (edges == null || edges.length == 0) return null;
        HashMap<Integer,Set<Integer>> map =  new HashMap<>();
        HashMap<Integer, Integer>  indegree = new HashMap<>();
        for (int[] edge : edges){
            if (!map.containsKey(edge[0])){
                map.put(edge[0], new HashSet<>());
            }
            map.get(edge[0]).add(edge[1]);
            indegree.put(edge[1],indegree.getOrDefault(edge[1],0)+1);
        }
//        List<Integer> zeroList = new ArrayList<>();
//        List<Integer> oneList = new ArrayList<>();
//        for (int key : indegree.keySet()){
//            if (indegree.get(key) == 0){
//                zeroList.add(key);
//            }
//            if (indegree.get(key) == 1){
//                oneList.add(key);
//            }
//        }
//        System.out.println("key value");
//        for (int key : indegree.keySet()){
//            System.out.println("key :" + key +" value" +indegree.get(key));
//        }
//        System.out.println("zero list");
//        for (int i : zeroList){
//            System.out.println(i);
//        }
//
//        System.out.println("one list");
//        for (int i : oneList){
//            System.out.println(i);
//        }

        return null;
    }

    public static void main(String...a){
        int[][] edges = {{1,2},{2,3},{1,4},{1,3}};
        findParentQuestionOne(edges);
    }

    // 反向建图， 然后对每个parent点做bfs， 看看他有没有公共的子节点。
    public boolean ifExistAncestorParent(int[][] edges , int target1 , int target2){

        if (edges == null || edges.length == 0) return false;
        HashMap<Integer,Set<Integer>> map =  new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        // Build a reverse map, parent--->kid
        int n = 0;
        for (int[] edge : edges){
            if (!map.containsKey(edge[1])){
                map.put(edge[1],new HashSet<Integer>());
            }
            map.get(edge[1]).add(edge[0]);
            // 找最大的可能的点 n
            n = Math.max(n,Math.max(edge[1],edge[0]));
        }
        // Do  bfs from each parent node.
        for (int i = 0 ; i < n ; i++){
            if (visited.containsKey(i) && target1 == i && target2 == i){
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            visited.clear();
            q.offer(i);
            while (!q.isEmpty()){
                int cur = q.poll();
                visited.put(cur,true);
                for (int child : map.get(cur)){
                    q.offer(child);
                }
            }
            if (visited.containsKey(target1) && visited.containsKey(target2)){
                return true;
            }
        }
        return false;
    }
}
