package company.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumIndexSumOfTwoLists599 {
    class compareType{
        int rank;
        String name;
        public compareType(int rank, String name){
            this.rank = rank;
            this.name = name;
        }
    }
    /*
     自己做的太复杂了。。。
     */
    public String[] findRestaurantPersonalDone(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0)
            return null;
        HashMap<String , Integer> map = new HashMap<>();

        for (int i = 0 ; i < list1.length ; i++){
            map.put(list1[i] , i);
        }
        PriorityQueue<compareType> q = new PriorityQueue<>((a,b)->(a.rank - b.rank));
        for (int j = 0 ; j < list2.length ; j++){
            if (map.containsKey(list2[j])){
                compareType cur = new compareType((j + map.get(list2[j])) , list2[j]);
                q.offer(cur);
            }
        }
        List<String> helper = new ArrayList<>();
        String firstName = q.peek().name;
        int firstRank = q.peek().rank;
        helper.add(firstName);
        q.poll();
        while (!q.isEmpty()&&q.peek().rank == firstRank){
            helper.add(q.poll().name);
        }
        String[] res = new String[helper.size()];
        for (int i = 0 ; i < res.length ; i++){
            res[i] = helper.get(i);
        }
        return res;
    }

    /*
    这个才是正确refresh 数组的操作。 应该能会做的。。。思维懒惰了
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        ArrayList<String> result = new ArrayList<>();
        int leastIndexSum = Integer.MAX_VALUE;

        for(int i = 0 ; i<list1.length;i++){
            map.put(list1[i],i);
        }

        for (int i = 0; i < list2.length;i++){
            if(map.containsKey(list2[i])){
                //count index sum
                int indexSum = map.get(list2[i]) + i;
                if(indexSum == leastIndexSum){
                    result.add(list2[i]);
                }
                // if indexSum equal min one, put it in result
                if(indexSum<leastIndexSum){
                    leastIndexSum = indexSum;
                    result.clear();
                    result.add(list2[i]);
                }
            }
        }
        String[] res = new String[result.size()];
        for(int i = 0 ;i<result.size();i++){
            res[i] = result.get(i);
        }

        return res;
    }
}
