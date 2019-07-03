package graph.bfs;

import java.util.*;

/**
 * Created by yangw on 2019/6/27.
 * basic bfs
 */
public class searchGraphNode {
  class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
                     label = x; neighbors = new ArrayList<UndirectedGraphNode>();
                 }
  }
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                     Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,int target){
            if (graph == null || graph.size() == 0 || node == null) return null;
            if (values.get(node) == target) return node;

        HashSet<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neigh : cur.neighbors){
                if (set.contains(neigh)){
                    continue;
                }
                if(neigh.label == target){
                    return node;
                }
                set.add(neigh);
                queue.offer(neigh);
            }
        }
        return null;
    }
}
