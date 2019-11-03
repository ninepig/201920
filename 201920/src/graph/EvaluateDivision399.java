package graph;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by yangw on 2019/10/31.
 * https://zxi.mytechroad.com/blog/graph/leetcode-399-evaluate-division/
 */
public class EvaluateDivision399 {

    // DFS o(e + q*E) space o(e)
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ans = new double[queries.length];
        Map<String, HashMap<String , Double>> graph = new HashMap<>();
        for (int i = 0 ; i < equations.length ; i++){
            String x = equations[i][0];
            String y = equations[i][1];
            double ratio = values[i];
            graph.computeIfAbsent(x, l -> new HashMap<String , Double>()).put(y,ratio);
            graph.computeIfAbsent(y, l -> new HashMap<String , Double>()).put(x,1/ratio);
        }

        for (int i = 0 ; i < queries.length ; i++){
            String x = queries[i][0];
            String y = queries[i][1];
            if (!graph.containsKey(x) || !graph.containsKey(y)){
                ans[i] = -1;
            }else{
                ans[i] = dfs(x,y,new HashSet<>(),graph);
            }
        }
        return ans;
    }

    private double dfs(String x, String y, HashSet<Object> visited, Map<String, HashMap<String, Double>> graph) {
        if (x.equals(y)) return 1.0;
        visited.add(x);
        if (!graph.containsKey(x)) return -1;
        for (String n : graph.get(x).keySet()){
            if (visited.contains(n)) continue;
            visited.add(n);
            double d = dfs(n,y,visited,graph);
            if (d > 0) return d * graph.get(x).get(n);
        }
        return -1.0;
    }

   class Node {
        public String parent;
        public double ratio;
        public Node(String parent, double ratio){
            this.parent = parent;
            this.ratio = ratio;
        }
   }
    // Time O(q+e) space O(e)
   class UnionFindSet{
        private Map<String, Node> parents = new HashMap<>();

        public Node find(String s){
            if (!parents.containsKey(s)) return null;
            Node  n = parents.get(s);
            if (!n.parent.equals(s)){
                Node p = find(n.parent);
                n.parent = p.parent;
                n.ratio *= p.ratio;
            }
            return n;
        }


       public void union(String s, String p, double ratio){
            boolean hasS = parents.containsKey(s);
            boolean hasP = parents.containsKey(p);
            if (!hasP && !hasS){
                parents.put(s,new Node(p, ratio));
                parents.put(p,new Node(s,1/ratio));
            }else if (!hasP){
                parents.put(p,new Node(s,1/ratio));
            }else if (!hasS){
                parents.put(s,new Node(p,ratio));
            }else {
                Node rs = find(s);
                Node rp = find(p);
                rs.parent = rp.parent;
                rs.ratio = ratio / rs.ratio * rp.ratio;
            }
       }
        public double[] calcEquation(String[][] equations , double[] values , String[][] queries){
            UnionFindSet uf = new UnionFindSet();
            double[] res = new double[values.length];

            for (int i = 0 ; i< equations.length ; i++){
                uf.union(equations[i][0],equations[i][1],values[i]);
            }

            for (int i = 0 ; i < queries.length ; i++){
                Node rx = find(queries[i][0]);
                Node ry = find(queries[i][1]);
                if (rx == null || ry == null || !rx.parent.equals(ry.parent)){
                    res[i] = -1;
                }else {
                    res[i] = rx.ratio / ry.ratio;
                }
            }
            return res;
        }


   }


}
