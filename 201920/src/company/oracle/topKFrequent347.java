package company.oracle;

import java.util.*;

public class topKFrequent347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        HashMap<Integer , Integer> frequencyMap = new HashMap<>();
        for (int num : nums){
            frequencyMap.put(num , frequencyMap.getOrDefault(num , 0 ) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>( (n1,n2) ->
                frequencyMap.get(n1) - frequencyMap.get(n2));

        for(int n : frequencyMap.keySet()){
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<Integer> res =  new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;

    }
    // 利用List作为bucket！  就不需要heap， 从frequency越大的开始。
    // freqeucny 最大也就是array 的length 这样就是o（n）的时间了
    public List<Integer> topKFrequentBucketVersion(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

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
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}
