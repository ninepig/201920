package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yangw on 2019/10/22.
 * 做法：
 维护三个点的集合：

 白点集合，里面放还没explore的点

 灰点集合，里面放正在explore的点，当前的灰点们表示一条正在explore的路径，这个路径上的每个点都是灰的

 黑点集合，里面放已经explore的点且这些点不构成环

 如果我将要的访问的点是黑点，我是否需要访问他？
 答：不需要，一个点是黑的表示这个点的所有孩子(邻居)都explore过了，且没发现环，且这个点的所有孩子必定也全是黑的。

 何时把一个点由灰变黑？
 答：当这个点的所有孩子都访问完(都已变黑)了且没有发现环

 如果我将要访问的点是个灰点，说明什么？
 答：发现了环。假设explore到了cur点，cur点为灰色，此时所有其他的灰色点必定都是我的祖先，因为他们都是当前explore的路径上的点，
 cur在最战线的最前方explore，如果cur点在explore的时候发现自己的的孩子(邻居)有一个灰色，表示下面这个点即是我的祖先也是我的孩子，
 说明从cur可以走到cur自己，即出现了环。

 */
public class DirectlyGraphCycleDetect {
    // DFS 3 color methods
    class threeColoringMethod{
        public boolean hasCycleInDirectlyGraph(int n , int[][] edges){
            HashSet<Integer> white = new HashSet<>();
            HashSet<Integer> grey = new HashSet<>();
            HashSet<Integer> black = new HashSet<>();

            List<List<Integer>> adjList = new ArrayList<>();

            for ( int i = 0 ; i < n ; i++){
                white.add(new Integer(i));
                adjList.add(new ArrayList<>());
            }
            for (int[] edge : edges){
                adjList.get(edge[0]).add(edge[1]);
            }
            // 之前题目里做到过的，一旦有一个条件成立，就返回！ 不成立则是走全部的循环

            for (int i = 0 ; i < n ; i++){
                if (white.contains(i)) {
                    if(dfs(i,white,grey,black,adjList)){
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean dfs(int i, HashSet<Integer> white, HashSet<Integer> grey, HashSet<Integer> black, List<List<Integer>> adjList) {
            white.remove(i);
            grey.add(i); // Visiting this grey point
            for (int neightbour : adjList.get(i)){
                if (white.contains(neightbour)){
                    if (dfs(neightbour,white,grey,black,adjList)){
                        return true;
                    }
                }
                // When we find grey , means we detected cycle
                if (grey.contains(neightbour)){
                    return true;
                }
                if (black.contains(neightbour)){
                    continue;
                }
            }
            grey.remove(i);
            black.add(i);
            return false;
        }


    }

}
