package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/26.
 * https://www.jianshu.com/p/da40edfb5b08
 */
public class Maze {
    static int[] moveRow = {0, 1, 0, -1};
    static int[] moveCol = {1, 0, -1, 0};//用0和1代表4个方向，类似于枚举类

    static class MazeNode {//建立内部类，记录路径
        public int row;
        public int col;
        public MazeNode pre;

        public MazeNode(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {//直接重写toString方法，print即可
            return "(" + row + "," + col + ")";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int ROW = scanner.nextInt();
            int COL = scanner.nextInt();
            int[][] maze = new int[ROW][COL];//迷宫初始化
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            MazeNode start = new MazeNode(0, 0);
//            ArrayList<MazeNode> result = solution(maze,start);//路径
            ArrayList<MazeNode> result = solution1(maze, start);
            for (int i = result.size() - 1; i >= 0; i--) {
                System.out.println(result.get(i));
            }
            /*
(0,0)
(0,1)
(0,2)
(1,2)
(2,2)

(0,0)
(0,1)
(0,2)
(1,2)
(2,2)
             */

//            for (int i = 0; i < result.size(); i++) {
//                System.out.println(result.get(i));
//
//            }
        }
    }

    private static ArrayList<MazeNode> solution1(int[][] maze, MazeNode start) {//深度遍历
        ArrayList<MazeNode> list = new ArrayList<>();
        MazeNode node = new MazeNode(0, 0);
        int row = maze.length;
        int col = maze[0].length;
        boolean mark[][] = new boolean[row][col];
        BFS(maze, start, mark, list, node);
        ArrayList<MazeNode> result = new ArrayList<>();
        while (node.row != 0 || node.col != 0) {
            result.add(node);
            node = node.pre;
        }
        result.add(new MazeNode(0, 0));
        return result;
    }

    private static void BFS(int[][] maze, MazeNode start, boolean[][] mark, ArrayList<MazeNode> list, MazeNode end) {
        Queue<MazeNode> queue = new LinkedList<>();
        queue.add(start);//BFS用队列
        while (!queue.isEmpty()) {
            MazeNode node = queue.poll();//取出队首的节点
            list.add(node);
            if (node.row == maze.length - 1 && node.col == maze[0].length - 1) {
                end.col = node.col;
                end.row = node.row;
                end.pre = node.pre;
                return;
            }
            int i = node.row;
            int j = node.col;
            mark[i][j] = true;//访问标记

            for (int k = 0; k < 4; k++) {//for循环，把节点r的临界点都访问完才去访问孙子节点
                int tmpi = i + moveRow[k];
                int tmpj = j + moveCol[k];
                if (tmpi >= 0 && tmpi < maze.length && tmpj >= 0 && tmpj < maze[0].length && maze[tmpi][tmpj] == 0 && !mark[tmpi][tmpj]) {
                    MazeNode node1 = new MazeNode(tmpi, tmpj);
                    node1.pre = node;
                    list.add(node1);
                    queue.add(node1);
                }
            }
        }
    }


    private static ArrayList<MazeNode> solution(int[][] maze, MazeNode start) {
        int row = maze.length;
        int col = maze[0].length;
        boolean mark[][] = new boolean[row][col];
        ArrayList<MazeNode> path = new ArrayList<>();
        ArrayList<MazeNode> result = new ArrayList<>();
        DFS(maze, start, mark, path, result);
        return result;
    }

    private static void DFS(int[][] maze, MazeNode start, boolean[][] mark, ArrayList<MazeNode> path, ArrayList<MazeNode> result) {

        if (start.col == maze[0].length - 1 && start.row == maze.length - 1) {
            path.add(new MazeNode(maze.length - 1, maze[0].length - 1));
            int size = path.size();
            for (int i = 0; i < size; i++) {
                result.add(path.get(i));
            }
        }
        int i = start.row, j = start.col;
        mark[start.row][start.col] = true;
        path.add(start);
        for (int k = 0; k < 4; k++) {
            int tmpi = i + moveRow[k];
            int tmpj = j + moveCol[k];
            if (tmpi >= 0 && tmpi < maze.length && tmpj >= 0 && tmpj < maze[0].length && maze[tmpi][tmpj] == 0 && !mark[tmpi][tmpj]) {
                MazeNode node1 = new MazeNode(tmpi, tmpj);
                //或者用非递归的while(!path.isEmpty())  path.add(node1);
                DFS(maze, node1, mark, new ArrayList<>(path), result);//递归实现DFS
            }
        }
    }
}


