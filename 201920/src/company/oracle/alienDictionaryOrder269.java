package company.oracle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
topo的变形。 关键是构件图！ 构图！ 构图~

 */
public class alienDictionaryOrder269 {
    public String alienOrder(String[] dicts){
        if (dicts == null || dicts.length == 0) return "";
        HashMap<Character, HashSet<Character>>  graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        buildMap(graph,dicts,inDegree);
        StringBuilder sb = new StringBuilder();
        topoSorting(sb,inDegree,graph);

        return sb.length() == dicts.length ? sb.toString() : "";
    }

    private void topoSorting(StringBuilder sb, HashMap<Character, Integer> inDegree, HashMap<Character, HashSet<Character>> graph) {
        Queue<Character> q = new LinkedList<>();
        for (Character c : inDegree.keySet()){
            if (inDegree.get(c) == 0){
                q.offer(c);
            }
        }
        while (!q.isEmpty()){
            char cur = q.poll();
            sb.append(cur);
            for (char neigh : graph.get(cur)){
                inDegree.put(neigh,inDegree.get(neigh) - 1);
                if (inDegree.get(neigh) == 0){
                    q.offer(neigh);
                }
            }
        }
    }

    private void buildMap(HashMap<Character, HashSet<Character>> graph, String[] dicts, HashMap<Character, Integer> inDegree) {
        for (String str : dicts){
            for (char c : str.toCharArray()){
                if (!graph.containsKey(c)){
                    graph.put(c, new HashSet<>());
                }
            }
        }
        for (int i = 0 ; i  < dicts.length - 1 ; i++){
            String first = dicts[i];
            String second = dicts[i+1];
            int size = Math.min(first.length() , second.length());
            for (int j = 0 ; j < size ; j++){
                if (first.charAt(j) != second.charAt(j)){
                    graph.get(first.charAt(j)).add(second.charAt(j));
                    inDegree.put(second.charAt(j),inDegree.getOrDefault(second.charAt(j),0) + 1);
                }
                break;
            }
        }
    }
}
