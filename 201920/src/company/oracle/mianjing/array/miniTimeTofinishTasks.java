package company.oracle.mianjing.array;


import java.util.*;

// 有n个task，每个task有自己的执行时间，可以确保每个task都能同时独立运行。现在只有k个线程，k < n，怎么分配使得总时间最短
public class miniTimeTofinishTasks {
    public static int minTimeToFinishTasks(int k , int[] tasks){
        if (tasks == null || tasks.length == 0) return 0;
        if (k <= 0) return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        Arrays.sort(tasks);
        int count = 0;
        for (int i = tasks.length - 1 ; i >= 0 ; i--){
            if (q.size() < k){
                q.offer(tasks[i]);
                count++;
            }else {
                int temp = q.poll();
                temp += tasks[i];
                q.offer(temp);
            }
        }
        int res = q.poll();
        while (!q.isEmpty()){
            res = q.poll();
        }
        return res;
    }

    public static void  main(String... args){
        int[] a = new int[]{1,2,4};
        int k = 2;
        System.out.println(minTimeToFinishTasks(k,a));
    }

}
