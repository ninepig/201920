package company.oracle.mianjing.StringRelated;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
https://aaronice.gitbooks.io/lintcode/graph_search/number_of_islands.html
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=575215&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

面完oracle OCI的电面，是内推HM下的engineer面的，是个中国小哥人很不错。

大概10分钟相互介绍问了下project.
然后第一个题是转换braces,把)21(21)a1(，如果braces match就变成0，如果多余的)就是-1,多余的（就是1， 所以刚刚结果-121021a11)。 唯一要注意的就是-1会从)增加一个char.
第二问是islands,给一个2D array of 1 and 0,找多少个island,小哥只要我说方法不需要写，先说了DFS with memorization,然后说了下问题是stack可能因为N太大不够大，然后说了下BFS，最后还问有没有其他的，我说了union find,就是相邻的放在一个disjoint set里面走一遍。小哥貌似很满意。不过我觉得union_find效率不高n*nlogn,但是小哥这么问可能只是考察下知识点。

braces match都变成0，意思就是(和)都会变成0，只要match..  (21)变成0210

2个题一共我只花了不到20分钟的样子，小哥好像只准备了两个题，看样子是比较满意，然后any questions？问了点组的事情就提前结束了。

island bfs

 */
public class braceReplaceAndislandNumberThreeWays {

    public static String replaceBrace(String target){
        if (target == null || target.length() == 0) return target;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        for (int i = 0 ; i < target.length() ; i++){
            char c = target.charAt(i);
            if (c == '('){
                s.push(i);

            }else if (c == ')'){
                if (s.isEmpty()){
                    sb.append("-1");
                }else {
                    sb.insert(s.pop(),"0");
                    sb.append("0");
                }
            }else{
                sb.append(c);
            }
        }
        while (!s.isEmpty()){
            sb.insert(s.pop(),"1");
        }
        return sb.toString();
    }

    public static void  main(String ... args){
        String abc = ")21(21)a1(";
        System.out.println(replaceBrace(abc));
    }


    public int numberOfIsland(char[][] island){
        if(island == null || island.length == 0) return 0;
        boolean[][] helper = new boolean[island.length][island[0].length];
        int count = 0;
        for(int i = 0 ; i < island.length ; i++){
            for(int j = 0 ; j < island[0].length ; j++){
                if(island[i][j] == '1'){
                    count++;
                    dfs(helper, i , j , island);
                }
            }
        }
        return count;
    }


    public void dfs(boolean[][] helper , int i , int j , char[][] island){
        if( i < 0 || i >= island.length || j < 0 || j >= island.length || helper[i][j] == true || island[i][j] == '0'){
            return;
        }

        helper[i][j] = true;
        dfs(helper, i+1 , j, island);
        dfs(helper, i-1 , j, island);
        dfs(helper, i , j+1 ,island);
        dfs(helper, i , j-1 ,island);


    }


    class Solution {
        int[][] dir = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

        class Point {
            int row;
            int col;
            Point (int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            int numIslands = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        numIslands++;
                        grid[i][j] = '0';
                        // BFS
                        Queue<Point> q = new LinkedList<>();
                        q.offer(new Point(i, j));
                        while (!q.isEmpty()) {
                            Point p = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int ni = p.row + dir[k][0];
                                int nj = p.col + dir[k][1];
                                if (ni >= 0 && ni < m &&
                                        nj >= 0 && nj < n &&
                                        grid[ni][nj] == '1') {
                                    grid[ni][nj] = '0';
                                    q.offer(new Point(ni, nj));
                                }
                            }
                        }
                    }
                }
            }
            return numIslands;
        }
    }

    // UF N*N LOGN
    class Solution2 {
        int[][] distance = { { 1, 0 }, {-1, 0 }, { 0, 1 }, { 0, -1 } };
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            UnionFind uf = new UnionFind(grid);
            int rows = grid.length;
            int cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        for (int[] d: distance) {
                            int x = i + d[0];
                            int y = j + d[1];
                            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                                int id1 = i * cols + j;
                                int id2 = x * cols + y;
                                uf.union(id1, id2);
                            }
                        }
                    }
                }
            }
            return uf.count;
        }

        class UnionFind {
            int[] father;
            int m, n;
            int count = 0;
            UnionFind(char[][] grid) {
                m = grid.length;
                n = grid[0].length;
                father = new int[m * n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == '1') {
                            int id = i * n + j;
                            father[id] = id;
                            count++;
                        }
                    }
                }
            }
            public void union(int node1, int node2) {
                int find1 = find(node1);
                int find2 = find(node2);
                if (find1 != find2) {
                    father[find1] = find2;
                    count--;
                }
            }
            public int find(int node) {
                if (father[node] == node) {
                    return node;
                }
                father[node] = find(father[node]);
                return father[node];
            }
        }
    }
}
