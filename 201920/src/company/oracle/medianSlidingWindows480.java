package company.oracle;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
   1 两个 pq 来做，最大堆用来维护小的一半， 最小堆用来维护大的一半。
   2 保持size很关键。
   3 需要反复写来练习。
   4 同时要remove的一步。
 */
public class medianSlidingWindows480 {
    public double[] medianSlidingWindow(int[] nums , int k){
        int n = nums.length;
        int m = n - k + 1; // size of output array
        double[] res = new double[m];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0 ; i < nums.length ; i++){
            int cur = nums[i];

            // Max heap use to store smaller half.
            // If the number is smaller than maxHeap max, put it in maxHeap.
            if (maxHeap.size() == 0 || maxHeap.peek() >= cur){
                maxHeap.add(cur);
            }else {
                minHeap.add(cur);
            }

            if (minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() > minHeap.size() + 1){
                minHeap.add(maxHeap.poll());
            }
            // time to output.
            if (i - k + 1>=0){
                if (k % 2 ==0){
                    res[i-k+1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
                }else {
                    res[i -k + 1] = maxHeap.peek();
                }
                int remove = nums[i-k+1];
                if (remove <= maxHeap.peek()){
                    maxHeap.remove(remove);
                }else {
                    minHeap.remove(remove);
                }
                if (minHeap.size() > maxHeap.size())
                    maxHeap.add(minHeap.poll());
                if (maxHeap.size() > minHeap.size() + 1)
                    minHeap.add(maxHeap.poll());
            }
        }
        return res;
    }
}
