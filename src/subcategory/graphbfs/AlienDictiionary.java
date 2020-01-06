package subcategory.graphbfs;

import java.util.*;

/**
 * Created by yangw on 2019/7/4.
 */
public class AlienDictiionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0){
            return "";
        }
        Map<Character,HashSet<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];
        buildGraph(words,graph,indegree);
        String order = topoSort(graph,indegree);
        return graph.size() == order.length() ? order : "";
    }



    private void buildGraph(String[] words, Map<Character, HashSet<Character>> graph, int[] indegree) {
        for (String word :  words){
            for (char c : word.toCharArray()){
                graph.put(c,new HashSet<>());
            }
        }
        for (int i = 1 ; i < words.length ; i++){
            String firstWord = words[i-1];
            String secondWord = words[i];
            int length = Math.min(firstWord.length(),secondWord.length());

            for (int j = 0 ; j < length ; j++){
                char parent = firstWord.charAt(j);
                char child = secondWord.charAt(j);
                if (parent!=child){
                    if (!graph.get(parent).contains(child)){
                        graph.get(parent).add(child);
                        indegree[child - 'a']++;
                    }
                    //Order is important
                    break;//rest comparision is meaningless & not record it!
                }

            }
        }
    }

    private String topoSort(Map<Character, HashSet<Character>> graph, int[] indegree) {
        Queue<Character> q = new ArrayDeque<>();
        for (char c : graph.keySet()){
            if (indegree[c - 'a'] == 0){
                q.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            char temp = q.poll();
            sb.append(temp);
            for (char node : graph.get(temp)){
                indegree[node - 'a']--;
                if (indegree[node -'a'] == 0) {
                    q.offer(node);
                }
            }
        }
        return sb.toString();
    }


}
