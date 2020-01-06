package subcategory.PQ;

import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/7.
 */
public class FindMedianFromDataStream {
    PriorityQueue<Integer> lower, higher;
    public FindMedianFromDataStream() {
        lower = new PriorityQueue<>((a,b)-> b - a);
        higher = new PriorityQueue<>();
    }
    public void addNum(int num) {
        lower.offer(num);
        higher.offer(lower.poll());
        if(lower.size() < higher.size()){
            lower.offer(higher.poll());
        }
    }

    public double findMedian() {
        if(lower.size() == higher.size()){
            return (lower.peek() + higher.peek())/2.0;
        }else {
            return lower.peek()*1.0;
        }
    }
}
