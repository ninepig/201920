package graph;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;


/**
 * Created by yangw on 2019/10/22.
 * classic topo sorting
 * https://zhuhan0.blogspot.com/2017/06/leetcode-269-alien-dictionary.html
 */
public class alienDictionaryOrder269 {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        HashMap<Character,HashSet<Character>> graph = new HashMap<>();
        int[] indegree = new int[words.length];
        buildGraph(graph,indegree,words);
        String order = topoSorting(graph,indegree,words);

        return order.length() == words.length ? order : "";
    }

    private String topoSorting(HashMap<Character, HashSet<Character>> graph, int[] inDegree, String[] words) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.toString();
    }

    private void buildGraph(HashMap<Character, HashSet<Character>> graph, int[] indegree, String[] words) {
        // Generating charater graph map
        for (String word : words){
            for (char c: word.toCharArray()){
                graph.put(c, new HashSet<>());
            }
        }
        for (int i = 0 ; i < words.length ; i++){
            String first = words[i-1];
            String second = words[i];
            int length = Math.min(first.length() , second.length());

            for (int j = 0  ; j < length ; j++){
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent!= child){
                    if (!graph.get(parent).contains(child)){
                        graph.get(parent).add(child);
                        indegree[child - 'a']++;
                    }
                    break;
                }
            }
        }
    }
}