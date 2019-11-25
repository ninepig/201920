package company.oracle;

import java.util.*;

public class WordLadder126 {
    /*
       先用bfs 构成图， 也就是所有点到所有点的距离， 以及所有点的临边图， 利用wordlist 构成可达到的点的图
       再用dfs 去找最短的符合要求的路径。
     */
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        HashMap<String , ArrayList<String>> nodeNeighbours = new HashMap<>();
        HashMap<String , Integer> distance = new HashMap<>();
        ArrayList<String> solution = new ArrayList<>();

        dict.add(start);

        bfs(start, end , dict , nodeNeighbours , distance);
        dfs(start, end , solution , nodeNeighbours , distance , res);

        return res;

    }

    private void dfs(String cur, String end, ArrayList<String> solution, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end,solution, nodeNeighbors, distance , res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    private void bfs(String start, String end, HashSet<String> dict, HashMap<String, ArrayList<String>> nodeNeighbours, HashMap<String, Integer> distance) {
        for (String str : dict){
            nodeNeighbours.put( str , new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start , 0);

        while (!queue.isEmpty()){
            int size = queue.size();
            boolean foundEnd = false;
            for ( int i = 0 ; i < size ; i++){
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbours = getNeighbors(cur,dict);

                for (String neighbour : neighbours){
                    nodeNeighbours.get(cur).add(neighbour);
                    if (!distance.containsKey(neighbour)){
                        distance.put(neighbour, curDistance + 1);
                        if (end.equals(neighbour)) foundEnd = true;
                        else
                            queue.offer(neighbour);
                    }
                }

                if (foundEnd)
                    break;;
            }
        }
    }


    // Find all next level nodes.
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }



}
