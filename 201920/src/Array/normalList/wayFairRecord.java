package Array.normalList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
输入一个二维数组，代表一组人同一天进入房间刷卡的数据。比如 【Tom，830】，【Tom，915】,【John，845】，【Tom，900】，【Tom，1100】，【Tom，929】。。。不排序，
没重复。要输出所有曾经在一个小时内，有大于等于3次记录的人和时间（这里的时间必须排序）。假如一个人有多个小时都进入了超过3次，输出最早的一组。比如我上面这个，应该输出：Tom： 830 900 915 929
 */
public class wayFairRecord {
        public HashMap<String , List<Integer>> getRecordAndName(String[][] data){
            if (data == null || data.length == 0) return null;
            HashMap<String , List<Integer>> res =  new HashMap<>();
            HashMap<String, PriorityQueue<Integer>> q = new HashMap<>();
            for (String[] point : data){
                String name = point[0];
                int time = Integer.parseInt(point[1]);
                if (!q.containsKey(name)){
                    q.put(name, new PriorityQueue<>());
                    q.get(name).add(time);
                }else {
                    // within an hour.
                   if( (time - q.get(name).peek()) < 60){
                       q.get(name).offer(time);
                   }else {
                       // We have more than 3 already.
                       if (q.get(name).size() >= 3){
                           continue;
                       }else {
                           q.get(name).poll();
                           q.get(name).offer(time);
                       }
                   }
                }
            }

            for (String key : q.keySet()){
                if (q.get(key).size() >= 3){
                    res.put(key, new ArrayList<>(q.get(key)));
                }
            }
            return res;
        }

        public static void main(String ... args){

        }
}
