package company.oracle.onsiteMianjing;

import java.util.*;

/*
这道有个特别要注意的就是 当达到K的时候 有若干个 怎么办？ 这道题是灭有考虑的
但是实际上你需要考虑。 应该是一个一个加 如果面试官要求最多就是K个
 */
public class topKfrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(
                (w1, w2) -> map.get(w1) != map.get(w2) ?
                        // w2.compareTo(w1) means we want abc be the first.
                        // So we let cba to pop first if the heap is full.
                        map.get(w1) - map.get(w2) : w2.compareTo(w1));

        for (String word : map.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }

        Collections.reverse(res);
        return res;
    }

    public List<String> topKFrequentBucket(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        ArrayList<String>[] bucket = new ArrayList[words.length];

        for (String key : map.keySet()){
            if (map.get(key) != 0){
                bucket[map.get(key)] = new ArrayList<>();
                bucket[map.get(key)].add(key);
            }
        }

        for (int i = bucket.length  - 1 ; i >= 0 ; i--){
            if (res.size() <= k) {
                if (bucket[i] != null) {
                    Collections.reverse(bucket[i]);
                    res.addAll(bucket[i]);
                }
            }
        }
        return res;
    }

}
