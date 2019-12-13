package company.oracle.mianjing.array;

import java.util.*;
/*

https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=552444&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

https://stackoverflow.com/questions/21692624/design-a-system-to-keep-top-k-frequent-words-real-time

假狗云朋友帮忙内推的组，整个面试流程感觉比较混乱。

题目是高频题散撕其，秒了。

follow up，实现分布式散撕其，如何hash？如何map到每一台机器上？reducer怎么做？

hash 就是 get mode to mapping to different device using index or line

map preprocess ， trim word

reducer getCount

 */
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
