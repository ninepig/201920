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

    // TODO union find


}
