package graph.graph.exersice.round2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yangw on 2019/10/29.
 */
public class DirectlyGraphCycelDetect {
    public boolean hasCycleInDirectlyGraphThreeColor(int n, int[][] edges) {
        HashSet<Integer> white = new HashSet<>();
        HashSet<Integer> grey = new HashSet<>();
        HashSet<Integer> black = new HashSet<>();

        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0 ; i < n ; i++){
            map.add(new ArrayList<>());
            white.add(i);
        }

        for (int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
        }
        // 之前题目里做到过的，一旦有一个条件成立，就返回！ 不成立则是走全部的循环
        for (int i = 0 ; i < n ; i++){
            if (white.contains(i)){
                if (dfs(white,grey,black,i,map)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(HashSet<Integer> white, HashSet<Integer> grey, HashSet<Integer> black, int i, List<List<Integer>> map) {
        white.remove(i);
        grey.add(i);
        for (int nei: map.get(i)){
            if (white.contains(nei)){
                if (dfs(white,grey,black,nei,map)){
                    return true;
                }
            }
            if (grey.contains(nei)){
                return true;
            }
            if (black.contains(nei)){
                continue;
            }
        }
        grey.remove(i);
        black.add(i);
        // dfs 最终也要返回一个结果
        return false;
    }

    public boolean topoWay(int n , int[][] edges){
        // 如果是topo 的话 ，就是完全 207的做法。
        return false;
    }
}