package graph.graph.exersice.round2;

import java.util.*;

/**
 * Created by yangw on 2019/10/26.
 * time : building graph, take n/ topo sording , o(v + e)
 */
public class alienDictionaryOrder269second {


    public String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();//<c, char after c>
        HashMap<Character, Integer> degree = new HashMap<Character, Integer>();//<c, # of char before c>
        StringBuilder res = new StringBuilder();
        //initialize degree map
        for(int i = 0; i < words.length; i++){
            char[] word = words[i].toCharArray();
            for(int j = 0; j < word.length; j++){
                degree.put(word[j], 0);
            }
        }
        //compare adjacent string & fill map
        for(int i = 0; i < words.length - 1; i++){
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for(int j = 0; j < len; j++){
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2){
                    Set<Character> set = new HashSet<Character>();//watch 'Set' declaration
                    if(map.containsKey(c1))set = map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;//rest comparision is meaningless & not record it!
                }else{
                    //edge case - no order: ["wrtkj","wrt"] 1:next stop at end 2: cur still have lefts
                    if(j + 1 == next.length() && j + 1 < cur.length())
                        break;
                }
            }
        }
        //BFS - use Queue to pop char in order
        Queue<Character> queue = new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0){
                queue.add(c);//eg:[zx,zy], c: z,x
            }
        }
        while(!queue.isEmpty()){
            char cur = queue.remove();
            res.append(cur);
            if(map.containsKey(cur)){
                for(char c: map.get(cur)){
                    degree.put(c, degree.get(c) - 1);
                    if(degree.get(c) == 0)queue.add(c);//add next char
                }
            }
        }
        //avoid loops. only < possible -- eg: ["qd","ab"] res = qa
        if(res.length() != degree.size())return "";
        return res.toString();
    }

    // It looks like something wrong here.
    public String getOrder(String[] words){
        if (words == null || words.length == 0) return "";

        HashMap<Character,HashSet<Character>> map = new HashMap<>();
        int[] indegree  = new int[words.length];
        StringBuffer order = new StringBuffer();

        buildingGraph(words, map , indegree);
        topoLogicalSorting(words,map,indegree,order);

        return order.length() == words.length ? order.toString(): "";

    }
    // Big idea !
    private void topoLogicalSorting(String[] words, HashMap<Character, HashSet<Character>> map, int[] indegree, StringBuffer order) {
        Queue<Character> q = new LinkedList<>();
        for (char key : map.keySet()){
            if (indegree[key - 'a'] == 0){
                q.add(key);
            }
        }
        while (!q.isEmpty()){
            char cur = q.poll();
            // get result , topological
            order.append(cur);
            for (char neighbor : map.get(cur)){
                if (--indegree[neighbor - 'a'] == 0){
                    q.offer(neighbor);
                }
            }
        }

    }

    private void buildingGraph(String[] words, HashMap<Character, HashSet<Character>> map, int[] indegree) {
            // Add unique char from words
            HashSet<Character> set = new HashSet<>();
            for (String word : words){
                for (char c : word.toCharArray()){
                    if (set.add(c)){
                        map.put(c, new HashSet<>());
                    }
                }
            }

            for (int i = 0 ; i < words.length - 1  ; i++){
                String first = words[i];
                String second = words[i+1];
                // Key , understanding what we do next, we compare firstString and secondString ,
                // one postion then one postion.
                int length = first.length() >= second.length() ? first.length() : second.length();
                for (int j = 0 ; j < length ; i++){
                    char parent = first.charAt(j);
                    char child = second.charAt(j);
                    if (parent != child){
                        if (!map.get(parent).contains(child)){
                            map.get(parent).add(child);
                            indegree[child - 'a']++;
                        }
                        // Just consider one postion for a word once !
                        break;
                    }
                }
            }

    }
}
