package company.oracle;

import java.util.*;

/*
The Java String compareTo() method is used for comparing two strings lexicographically.
 Each character of both the strings is converted into a Unicode value for comparison.
 If both the strings are equal then this method returns 0 else it returns positive or negative value.
 The result is positive if the first string is lexicographically greater than the second string else the result would be negative.



 How does Collections.Sort() work?
Internally the Sort method does call Compare method of the classes it is sorting.
To compare two elements, it asks “Which is greater?” Compare method returns -1, 0 or 1 to say if it is less than, equal, or greater to the other.
It uses this result to then determine if they should be swapped for its sort.
 如果你想升序，那么o1比o2小就是我想要的；所以返回-1，类比成false；表示我不想调整顺序
如果你想降序，那么o1比o2小不是我想要的；所以返回1，类比成true；表示我想调整顺序
 */
public class topFrequencyString692 {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1) != count.get(w2) ?
                        // 总算搞懂了。 要的就是abc排第一个。 因为是反向排的。如果相同的频率下。 cba先出来，也就是lexi排序在后的排在前面。所以为什么要用w2.compareTo(w1)
                        // Heap 的概念是谁排在前面。 谁就先出来。
                        count.get(w1) - count.get(w2) : w2.compareTo(w1));

        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) {
//            System.out.println(heap.peek());
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String... args) {
        String[] words = new String[]{"abc", "abc", "cba", "cba", "ddd"};
        List<String> res = topKFrequentBucket(words, 3);
        for (String test : res) {
            System.out.println(test);
        }

    }

    public static List<String> topKFrequentBucket(String[] words, int k) {
        Map<String , Integer> counter = new HashMap<>();
        for (String word : words){
            counter.put(word, counter.getOrDefault(word,0) + 1);
        }
        ArrayList<String>[] bucket = new ArrayList[words.length];
        for (String key : counter.keySet()){
//            System.out.println(key);
            // 容易犯错的地方
            if (bucket[counter.get(key)] == null) {
                bucket[counter.get(key)] = new ArrayList<>();
            }
            bucket[counter.get(key)].add(key);
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i = bucket.length - 1 ; i >= 0 ; i--){
            if (res.size() <= k){
                if (bucket[i] != null) {
//                    System.out.println(bucket[i].size());
                    Collections.sort(bucket[i]);
                    res.addAll(bucket[i]);
                }
            }else{
                break;
            }
        }

        return res;
    }
}