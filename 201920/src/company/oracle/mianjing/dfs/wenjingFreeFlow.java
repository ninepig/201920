package company.oracle.mianjing.dfs;

public class wenjingFreeFlow {

    final int EMPTY = 0;
    boolean flag = false;
    int count;
    int gridSize;
    int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean freeFlow(int[][] colors){
        if (colors == null || colors.length == 0){
            return false;
        }
        int currentColor = 0;
        boolean colorFound = false;
        gridSize = colors.length;
        count = 0;
        int[][] helper = new int[colors.length][colors[0].length];
        int x = 0 , y = 0;
        for (int i = 0 ; i < colors.length ; i ++ ){
            for (int j = 0 ; j < colors[0].length ; j++){
                if (colors[i][j] != currentColor){
                    currentColor = colors[i][j];
                    colorFound = false;
                    x = i;
                    y = j;
                    break;
                }
            }
            if (colorFound){
                break;
            }
        }
        DFS(x, y , currentColor, colors,helper);

        return flag;
    }

    private void DFS(int x, int y, int currentColor, int[][] helpers, int[][] colors) {
        if (colors[x][y] != 0 && colors[x][y] != currentColor){
            return;
        }
        if (checkBounds(x,y) || helpers[x][y]!=0){
            return ;
        }
        count++;
        helpers[x][y] = currentColor;

        for (int[] direct : direction){
            int nextX = x + direct[0];
            int nextY = y + direct[1];
            // next point available
            if (!checkBounds(nextX,nextY) && helpers[nextX][nextY] == 0){
                if (colors[nextX][nextY] == currentColor){
                    //Found the target pairing color
                    count++;
                    helpers[nextX][nextY] = currentColor;
                    if (count == gridSize * gridSize){
                        // Get all board filled
                        flag = true;
                        return;
                    }
                    for (int k = 0 ;  k < gridSize; k++){
                        for (int l = 0 ; l < gridSize;l++){
                            if (colors[k][l] != 0 && helpers[k][l] == 0 && colors[k][l] != currentColor){
                                int newColor = colors[k][l];
                                DFS(k, l , newColor , helpers, colors);
                            }
                        }
                    }
                    //Backtrack;
                    count--;
                    helpers[nextX][nextY] = 0;
                }else {
                    // If it is a path, we can connect. So we apply dfs here again.
                    if (helpers[nextX][nextY] == 0){
                        DFS(nextX, nextY , currentColor,helpers,colors);
                    }
                }
            }
        }
        count--;
        helpers[x][y] = 0;
    }

    private boolean checkBounds(int x, int y ) {
        return 0 > x || x >= gridSize || 0 > y || y >= gridSize;
    }
}
