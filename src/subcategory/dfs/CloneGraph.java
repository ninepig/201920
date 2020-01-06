package subcategory.dfs;

import java.util.*;

/**
 * Created by yangw on 2019/7/5.
 */
public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null ) return node;
        // First step, get all node in to a list
        List<UndirectedGraphNode> allNodes = helper(node);
        HashMap<UndirectedGraphNode,UndirectedGraphNode> dictionary = new HashMap<>();
        for (UndirectedGraphNode n : allNodes){
            dictionary.put(n,new UndirectedGraphNode(n.label));
        }

        // Copy to a new graph
        for (UndirectedGraphNode subNode : allNodes){
            UndirectedGraphNode newNode = dictionary.get(subNode);
            for (UndirectedGraphNode subNeigh : newNode.neighbors){
                newNode.neighbors.add(dictionary.get(subNeigh));
            }
        }
        return dictionary.get(node);
    }

    private List<UndirectedGraphNode> helper(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> q = new ArrayDeque<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        set.add(node);
        q.offer(node);
        while (!q.isEmpty()){
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode neigh : cur.neighbors){
                if (!set.contains(neigh)){
                    set.add(neigh);
                    q.offer(neigh);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
     }
}
