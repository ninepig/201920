package facebookprepare;

/**
 * Created by yangw on 2019/6/30.
 */
public class wallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0){
                    dfs(rooms, i, j,0);
                }
    }

    private void dfs(int[][] rooms, int i, int j,int d) {
        if(i<0||i>=rooms.length||j>=rooms[0].length||j<0||rooms[i][j]<d)//ensure min dis + avoid wall
            return;// <d: return wall + gate + ensure min distance
        rooms[i][j]=d;//i row,j col
        dfs(rooms, i - 1, j,d+1);
        dfs(rooms, i + 1, j,d+1);
        dfs(rooms, i, j - 1,d+1);
        dfs(rooms, i, j + 1,d+1);
    }

    public void wallsAndGates2(int[][] rooms) {
        if(rooms==null || rooms.length==0 || rooms[0]==null || rooms[0].length==0) return;
        int m = rooms.length;
        int n =rooms[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rooms[i][j] == Integer.MAX_VALUE) {
                    rooms[i][j] = search(rooms, visited, i, j, m, n);
                }
            }
        }
        return;
    }

    private int search(int[][] rooms, boolean[][] visited, int i, int j, int m, int n) {
        if(i<0 || i>m-1 || j<0 || j>n-1 || rooms[i][j] == -1) return Integer.MAX_VALUE;
        if(rooms[i][j]==0) return 0;
        if(visited[i][j]) return rooms[i][j];
        visited[i][j] = true;

        if(rooms[i][j]>0 && rooms[i][j]<Integer.MAX_VALUE) return rooms[i][j];

        int up = search(rooms, visited, i-1, j, m, n);
        int down = search(rooms, visited, i+1, j, m, n);
        int left = search(rooms, visited, i, j-1, m, n);
        int right = search(rooms, visited, i, j+1, m, n);

        visited[i][j] = false;

        int min = Math.min( Math.min(up, down), Math.min(left, right) );
        return min==Integer.MAX_VALUE ? min : min+1;
    }

}
