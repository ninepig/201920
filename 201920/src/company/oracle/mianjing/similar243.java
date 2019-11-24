package company.oracle.mianjing;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=572194&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 243 类似版本
 1 暴力
 2 两个标记

 follow up
 bfs
 maze problem
 */
public class similar243 {
    public static int closedDistanceTwoPoint(int[] target, int first, int second) {

        if (target == null || target.length == 0) return 0;

        int res = Integer.MAX_VALUE;

        // brutal force
        // Double loop to  get smallest one.

        // two pointer to record the newest postions
        int p1 = -1, p2 = -1;
        for (int i = 0; i < target.length; i++) {
            if (target[i] == first || target[i] == second) {
                if (first == target[i]) {
                    p1 = i;
                }
                if (second == target[i]) {
                    p2 = i;
                }
                if (p1 == -1 || p2 == -1) continue;
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }

        return res;
    }

    public static void main(String... args) {
//        int[] target = new int[]{1, 2, 3, 4, 2};
        int[][] target = new int[][] {new int[]{1, 2, 3, 4, 2},
                new int[]{4, 5, 6, 7, 8},
                new int[]{2, 3, 4, 6, 5},
                new int[]{5, 6, 9, 10, 12}};
        int first = 7, second = 1;
        System.out.println(closedDistanceTwoPointIn2dArray(target, first, second));
    }

    static class node{
        int x;
        int y;
        int val;
        public node(int x, int y , int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int closedDistanceTwoPointIn2dArray(int[][] target, int first, int second) {
        if (target == null || target.length == 0) return 0;
        int res = 0 ;
        int[] x = new int[]{ 0, 0, -1, 1};
        int[] y = new int[]{ 1, -1, 0, 0};
        Queue<node> q = new LinkedList<>();

        for (int i = 0 ; i < target.length ; i++){
            for (int j = 0 ; j < target[0].length ; j++){
                if (target[i][j] == first){
                    q.offer(new node(i,j,first));
                }
            }
        }

        while (!q.isEmpty()){
            int size = q.size();
            System.out.println("size " + size);
            res += 1;
            for (int i = 0 ; i < size ; i++){
                node cur = q.poll();
                for (int j = 0 ; j < x.length ; j++){
                    int newX = cur.x + x[j];
                    int newY = cur.y + y[j];
                    if (newX >= 0 && newX < target.length && newY >= 0 && newY < target[0].length){
                        if (target[newX][newY] == second) return res;
                        else q.offer(new node(newX,newY));
                    }
                }
            }
        }
        return  0;
    }
}