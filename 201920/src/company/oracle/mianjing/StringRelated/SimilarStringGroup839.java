package company.oracle.mianjing.StringRelated;

import java.util.LinkedList;
import java.util.Queue;

/*

https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=566325&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%8395D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
難題\電話面試 . LC 839
我做得不好

 */
public class SimilarStringGroup839 {
    // DFS go through all the string.
    // A tricker set A[i] == null to prune.
    //Yes you are correct. I think time complexity is O(n^2 * k), as I am calling each string in dfs method only once.
    public int numSimilarGroups2(String[] A) {
        if (A == null || A.length <= 1) return 0;
        int res = 0;
        for (int i = 0 ; i < A.length ; i++){
            if (A[i] == null){
                continue;
            }
            String cur = A[i];
            A[i] = null;
            res++;
            dfs(A, cur);
        }
        return res;
    }

    private void dfs(String[] a, String cur) {
        for (int i = 0 ; i < a.length ; i++){
            if (a[i] == null) continue;
            if (helper(a[i], cur)){
                String s = a[i];
                a[i] = null;
                dfs(a, s);
            }
        }
    }

    private boolean helper(String s, String cur) {
        int res = 0 , i = 0;
        while(res <= 2 && i < s.length()){
            if(s.charAt(i) != cur.charAt(i)){
                res++;
            }
            i++;
        }
        return res == 2;
    }

  //  O(N^2*W) W is A[0].length N is A.length

    public int numSimilarGroups(String[] A) {
        if (A == null || A.length == 0) return 0;
        boolean[] visited = new boolean[A.length];
        Queue<String> q = new LinkedList<>();

        int ans = 0;
        for (int i = 0 ; i < A.length ; i++){
            if (visited[i]) continue;
            ans++;
            q.offer(A[i]);
            while (!q.isEmpty()){
                String compare = q.poll();
                for (int j = 0 ;  j < A.length ; j++){
                    if (visited[j]) continue;
                    int diff = 0;
                    for (int l = 0 ; l < A[j].length() ; l++){
                        if (compare.charAt(l) != A[j].charAt(l)){
                            diff++;
                        }
                    }
                    if (diff == 2){
                        visited[j] = true;
                        q.offer(A[j]);
                    }
                }
            }
        }
        return ans;

    }
}
