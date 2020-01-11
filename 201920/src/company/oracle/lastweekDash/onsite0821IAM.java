package company.oracle.lastweekDash;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=544418&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class onsite0821IAM {
    /*
    Onsite：
     OCI很注重Culture fit，所以onsite之前，一定要把Recruiter发的OCI的Value好好看看，然后结合下自己的工作经历。
     第一轮：
             BQ + 算法。算法是Leetcode 1091， 我其实并没有做得很好，我觉得最重要是交流，并不会要求Code无bug啥的。
     第二轮：
             BQ + 算法。算法是binary tree 的in-order traversal。follow up是实现morris的写完，在交流的情况下写完了。
     第三轮：
             HM Lunch Interview。 接近1.5小时的聊天，BQ，问得还是很细的。
     第四轮：
            system design。 Design Messenger。问了很多问题，细节不少。
     第五轮：
            BQ。又是一个小时的聊天，本来说最后会出一道题的，结果就是结合经历聊天。

我觉得我应该是面的一般，给了offer，但是包不太给力。
     */

    class shortestPathInMatrix1091 {
        private int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

        public int shortestPathBinaryMatrix(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            if(grid[0][0]==1 || grid[m-1][n-1]==1) {
                return -1;
            }

            boolean[][] visited = new boolean[m][n];
            visited[0][0] = true;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0});

            int ans=0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for(int i=0;i<size;i++) {
                    int[] pop = queue.remove();
                    if(pop[0]==m-1 && pop[1]==n-1) {
                        return ans+1;
                    }
                    for (int k=0;k<8;k++) {
                        int nextX = dir[k][0]+pop[0];
                        int nextY = dir[k][1]+pop[1];

                        if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && !visited[nextX][nextY] && grid[nextX][nextY]==0) {
                            queue.add(new int[]{nextX,nextY});
                            visited[nextX][nextY]=true;
                        }
                    }
                }
                ans++;
            }
            return -1;
        }
    }
}
