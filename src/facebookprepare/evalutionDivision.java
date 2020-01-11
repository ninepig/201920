package facebookprepare;

import java.util.HashMap;

/**
 * Created by yangw on 2019/7/2.
 */
public class evalutionDivision {
    class Solution {
        class Node{
            public String parent;
            public double ratio;
            public Node(String parent, double ratio){
                this.parent = parent;
                this.ratio = ratio;
            }
        }

        class UnionFind{
            HashMap<String,Node> parents = new HashMap<>();

            public Node find(String s){
                // 如果所有节点里没有 s ，则返回null
                if(!parents.containsKey(s)) return  null;
                // 找到s的root节点
                Node n = parents.get(s);
                if(!n.parent.equals(s)){
                    Node p = find(n.parent);
                    n.parent = p.parent;
                    n.ratio *= p.ratio;
                }
                return n;
            }

            public void union(String s, String p, double ratio){
                boolean hasS = parents.containsKey(s);
                boolean hasP = parents.containsKey(p);
                if(!hasS && !hasP){
                    parents.put(s,new Node(p,ratio));
                    parents.put(p,new Node(p,1.0));
                }else if (!hasP){
                    parents.put(p,new Node(s,1.0/ratio));
                }else if (!hasS){
                    parents.put(s,new Node(p,ratio));
                }else{
                    Node rS = find(s);
                    Node rP = find(p);
                    rS.parent = rP.parent;
                    rS.ratio = ratio/ rS.ratio* rP.ratio;
                }
            }
        }

        public double[] calcEquation(String[][] equations, double[] values, String[][] queries){
            UnionFind u = new UnionFind();
            // 构建unionFind 集
            for(int i = 0 ; i < equations.length ; i++){
                u.union(equations[i][0],equations[i][1],values[i]);
            }
            double[] ans = new double[queries.length];

            for (int i = 0 ; i < queries.length ; i++){
                // 找到他们到达root的ratio值
                Node rx = u.find(queries[i][0]);
                Node ry = u.find(queries[i][1]);
                if(rx == null || ry == null || !rx.parent.equals(ry.parent)){
                    ans[i] = -1.0;
                }else{
                    ans[i] = rx.ratio / ry.ratio;
                }
            }
            return ans;
        }

    }
}
