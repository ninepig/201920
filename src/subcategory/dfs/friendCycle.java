package subcategory.dfs;

/**
 * Created by yangw on 2019/7/2.
 */
public class friendCycle {
    private void dfs(int[][] m, int[] visited, int studentNumber) {
        for (int i = 0 ; i < m.length ; i++ ){
            // target student is not visited && target and  current student is friend.
            if(visited[i] == 0 && m[studentNumber][i] == 1){
                visited[i] = 1;
                dfs(m,visited,i);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;

        int[] visited  = new int[M.length];
        int count = 0;
        for(int i = 0 ; i < M.length ; i++){
            // Current student is not visited
            if(visited[i] == 0){
                dfs(M,visited,i);
                count++;
            }
        }
        return count;
    }
}
