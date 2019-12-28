package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class robotWalkingAndKnightMoving {
    final char BLOCKER = '2';
    final char NON_BLOCKER = '1';
    final char EXIT = '3';
    int[] xMove = new int[]{1,-1,0,0,2,-2,0,0};
    int[] yMove = new int[]{0,0,1,-1,0,0,2,-2};


    //3. 三哥。一个room，一个robot，一些blocker，一个exit，robot可以走两种step，
    // 一种叫一小步move一个unit，一种叫一大步move两个unit。问走出去的最小step。bfs可以解.
    // BFS 一定要加set 要不然会无限循环！！！
    public int minStepToExit(char[][] map){
        if (map == null || map.length == 0) return 0;
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        Node start = new Node(0 , 0 ,0);
        q.offer(start);
        visited.add(start);
        while (!q.isEmpty()){
            Node cur = q.poll();
            if (map[cur.x][cur.y] == EXIT){
                return cur.step;
            }
            for (int i = 0 ; i < xMove.length ; i++){
                int newX = cur.x + xMove[i];
                int newY = cur.y + yMove[i];
                int newStep = cur.step + 1;
                Node current = new Node(newX, newY , newStep);
                if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length || map[newX][newY] == BLOCKER
                ||visited.contains(current)){
                    continue;
                }else {
                    q.offer(current);
                    visited.add(current);
                }
            }
        }
        // No way to get out.
        return -1;
    }
    class Node{
        int x ;
        int y;
        int step;
        Node(int x, int y, int step){
            this.x = x;
            this.y = y;
        }
        Node(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    // 马走格子
    public boolean knightGetEnd(int[][] map , int startX, int startY,int endX,  int endY){
        if (map == null || map.length == 0) return false;
        int[] newX = new int[]{1,-1,2,-2,1,-1,2,-2};
        int[] newY = new int[]{2,2,1,1,-2,-2,-1,-1};
        Queue<Node> q = new LinkedList<>();
        Node start = new Node(startX, startY);
        HashSet<Node> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()){
            Node cur = q.poll();
            if (cur.x == endX && cur.y == endY ){
                return true;
            }
            for (int i = 0 ; i< newX.length ; i++){
                int nextX = cur.x + newX[i];
                int nextY = cur.y + newY[i];
                Node next = new Node(nextX,nextY);
                if (nextX >= 0 && nextX < map.length && nextY >=0 && nextY < map[0].length && !visited.contains(next)){
                    q.offer(next);
                }
            }
        }
        return false;
    }
}
