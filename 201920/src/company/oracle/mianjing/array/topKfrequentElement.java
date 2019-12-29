package company.oracle.mianjing.array;

import java.util.*;

public class topKfrequentElement {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums){
            count.put(num, count.getOrDefault(num , 1));
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return count.get(o1) - count.get(o2);
            }
        });

        for (int item : count.keySet()){
            minHeap.add(item);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        // If we need sort this result.?
        while (!minHeap.isEmpty()){
            res.add(minHeap.poll());
        }
        return res;
    }

    public List<Integer> topKFrequentBucket(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 1));
        }

        ArrayList<Integer>[] buckets = new ArrayList[nums.length];
        // Using frequency to be the bucket index.
        for (int item : count.keySet()) {
            if (buckets[count.get(item)] != null) {
                buckets[count.get(item)] = new ArrayList<>();
            }
            buckets[count.get(item)].add(item);
        }

        for (int i = buckets.length; i >= 0; i--) {
            if (buckets[i] != null) {
                if (res.size() < k) {
                    res.addAll(buckets[i]);
                    // posibility to be k-2 and we have 3 in this bucket
                }
            }
        }

        return res;
    }


    // using treemap.
    public List<Integer> topKFrequentTreeMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        //nlogn
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}
