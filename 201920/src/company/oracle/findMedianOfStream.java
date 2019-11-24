package company.oracle;

import java.util.PriorityQueue;

/*
Heap insert logn
 */
public class findMedianOfStream {

    PriorityQueue<Integer> lower, higher;
    public findMedianOfStream() {
        lower = new PriorityQueue<>((a,b)-> b - a);
        higher = new PriorityQueue<>();
    }
    public void addNum(int num) {
        lower.add(num);
        higher.add(lower.poll());
        if (lower.size() < higher.size()){
            lower.add(higher.poll());
        }
    }

    // it should be peek for find!!
    public double findMedian() {
        if (higher.size() == lower.size()){
            return (higher.peek() + lower.peek()) /2;
        }else{
            return lower.poll() * 1.0;
        }
    }

//    If all integer numbers from the stream are between 0 and 100, how would you optimize it?
    // We just need a Array (0-100) to do this .
//    If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
// Still an array 0--100 and two counters one is under 100 / one is bigger than 100.
}
