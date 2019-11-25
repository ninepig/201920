package design;

import java.util.LinkedList;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.TreeMap;

/*
https://massivealgorithms.blogspot.com/2016/08/leetcode-362-design-hit-counter.html
 */
public class hitCounter362 {

    public static void main(String ... args){
        hitCounter hc = new hitCounter();
        hc.hits(1);
        hc.hits(2);
        hc.hits(3);
        System.out.println(hc.getHits(4));
        hc.hits(300);
        System.out.println(hc.getHits(300));
        System.out.println(hc.getHits(301));
    }
}

/*
a good solution, but we should know , time has been ordered.
so we should use queue to instead
 */
class hitCounter {
    TreeMap<Integer, Integer> treeMap;

    public hitCounter() {
        treeMap = new TreeMap<>();
    }

    public void hits(int number) {
        treeMap.put(number, treeMap.getOrDefault(number, 0) + 1);
    }

    // Range from key - 299 sec
    public int getHits(int key) {
        NavigableMap<Integer, Integer> targetmap = treeMap.subMap(key - 299, true, key, true);
        int result = 0;
        for (int cur : targetmap.keySet()) {
            result += targetmap.get(cur);
        }
        return result;
    }
}

class HitCounterQueueversion {
    Queue<Integer> q = null;
    /** Initialize your data structure here. */
    public HitCounterQueueversion() {
        q = new LinkedList<Integer>();
    }

    public void hit(int timestamp) {
        q.offer(timestamp);
    }


    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }
}

// Follow up, 我覺得我的方法也可以了啊。。treemap來做
// 利用兩個數組來維護
class HitCounter {
    private int[] times;
    private int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}
