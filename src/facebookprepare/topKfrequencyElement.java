package facebookprepare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangw on 2019/7/1.
 */
public class topKfrequencyElement {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // At least 2 (if all nums has one frequecny, we need size of two)
        List<Integer>[] buckets = new List[nums.length + 1];
        HashMap<Integer,Integer> map = new HashMap();
        // Count frequency
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

//         PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( (n1,n2) ->
//         map.get(n1) - map.get(n2));

//         for(int n : map.keySet()){
//             maxHeap.add(n);
//             if(maxHeap.size() > k){
//                 maxHeap.poll();
//             }
//         }

//         List<Integer> res = new ArrayList();
//         while(!maxHeap.isEmpty()){
//             res.add(0,maxHeap.poll());
//         }
//         return res;

        for(int num : map.keySet()){
            int frequency = map.get(num);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList();
            }
            buckets[frequency].add(num);
        }

        List<Integer> res = new ArrayList();

        for(int i = buckets.length - 1 ; i >= 0 && res.size() < k ; i--){
            if(buckets[i] != null){
                res.addAll(buckets[i]);
            }
        }
        return res;
    }
}
