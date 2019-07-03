package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class kthElementInStream {
    PriorityQueue<Integer> pq;
    int K ;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.K = k;
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        if(pq.size()<K){
            pq.offer(val);
        }else if (pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
